package Searcher;

import Index.Index;
import model.DocInfo;
import model.Weight;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DocSearcher {

    private static final String STOP_WORD_PATH = "E:\\Coding\\Java\\stop_word.txt";

    private HashSet<String> stopWords = new HashSet<>();

    private Index index = new Index();

    public DocSearcher() {
        index.load();
        loadStopWord();
    }

    // 完成整个搜索过程的方法
    // 参数（输入部分）用户给出的查询词
    // 返回值（输出部分）搜索结果的集合
    public List<Result> search(String query) {
        // 1.【分词】针对 query 查询词进行分词
        List<Term> oldTerms = ToAnalysis.parse(query).getTerms();
        List<Term> terms = new ArrayList<>();
        // 针对分词结果，使用停用词表进行过滤
        for (Term term : oldTerms) {
            if (stopWords.contains(term.getName())) {
                continue;
            }
            terms.add(term);
        }
        // 2.【触发】针对分词结果来查倒排
        List<List<Weight>> TermResult = new ArrayList<>();
        for (Term term : terms) {
            String word = term.getName();
            List<Weight> invertedList = index.getInverted(word);
            if (invertedList == null) {
                // 说明这个查询词在所有文档中都不存在
                continue;
            }
            TermResult.add(invertedList);
        }

        // 3. 【合并】针对多个分词结果触发出的相同文档，进行权重合并
        List<Weight> allTermResult = mergeResult(TermResult);
        // 4.【排序】针对触发结果按照权重降序排序
        allTermResult.sort(new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
        // 5.【包装结果】针对排序的结果，查正排，构造出要返回的数据
        List<Result> results = new ArrayList<>();
        for (Weight weight : allTermResult) {
            DocInfo docInfo = index.getDocInfo(weight.getDocId());
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setUrl(docInfo.getUrl());
            result.setDesc(GenDesc(docInfo.getContent(), terms));
            results.add(result);
        }
        return results;
    }

    // 通过这个类，来描述一个元素在二维数组中的位置
    static class Pos {
        public int row;
        public int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private List<Weight> mergeResult(List<List<Weight>> source) {
        // 在进行合并的时候，把多个行合并成一行
        // 合并过程中势必需要操作这个二维数组（二维 List）里面的每个元素
        // 操作元素涉及到“行”“列”这样的概念

        // 1. 先针对每一行进行排序，按照 id 进行升序排序
        for (List<Weight> curRow : source) {
            curRow.sort(new Comparator<Weight>() {
                @Override
                public int compare(Weight o1, Weight o2) {
                    return o1.getDocId() - o2.getDocId();
                }
            });
        }

        // 2. 借助优先队列，针对这些行进行合并
        //  target 表示合并的结果
        List<Weight> target = new ArrayList<>();
        // 2.1 创建一个优先级队列，并指定比较规则（按照 Weight 的 docId，取小的更优先）
        PriorityQueue<Pos> queue = new PriorityQueue<>(new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                // 先根据 pos 找到对应的 Weight 对象，再根据 Weight 的 docId 来排序
                Weight w1 = source.get(o1.row).get(o1.col);
                Weight w2 = source.get(o2.row).get(o2.col);
                return w1.getDocId() - w2.getDocId();
            }
        });
        // 2.2 初始化队列，把每一行的第一个元素放到队列中
        for (int row = 0; row < source.size(); row++) {
            // 初始插入的元素的 col 就是 0
            queue.offer(new Pos(row, 0));
        }
        // 2.3 循环的队列取队首元素（也就是当前这若干行中最小的元素）
        while (!queue.isEmpty()) {
            Pos minPos = queue.poll();
            Weight curWeight = source.get(minPos.row).get(minPos.col);
            // 2.4 看看这个取到的 Weight 是否和前一个插入到 target 中的结果是相同的 docId
            // 如果相同，就合并
            if (target.size() > 0) {
                // 取出上次插入的元素
                Weight lastWeight = target.get(target.size() - 1);
                if (lastWeight.getDocId() == curWeight.getDocId()) {
                    // 说明遇到了相同的文档
                    // 合并权重
                    lastWeight.setWeight(lastWeight.getWeight() + curWeight.getWeight());
                } else {
                    // 如果 docId 不同，就直接把 curWeight 插入到 target 的末尾
                    target.add(curWeight);
                }
            } else {
                // 如果 target 当前是空的，就直接插入即可
                target.add(curWeight);
            }
            // 2.5 把当前元素处理完之后，要把对应这个元素的光标往后移动
            // 去取这个一行的下一个元素
            Pos newPos = new Pos(minPos.row, minPos.col + 1);
            if (newPos.col >= source.get(newPos.row).size()) {
                // 如果移动光标之后，超出这一行的列数，就说明达到末尾了
                // 到达末尾之后说明这一行就处理完毕了
                continue;
            }
            queue.offer(newPos);
        }
        return target;
    }

    private void loadStopWord() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(STOP_WORD_PATH))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    // 读取文件完毕
                    break;
                }
                stopWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String GenDesc(String content, List<Term> terms) {
        // 先遍历分词结果，看看哪个结果在 content 中存在
        int firstPos = -1;
        for (Term term : terms) {
            // 分词库直接针对词进行转小写了
            // 正因为如此，就必须把正文内容也先转为小写，然后再查询
            String word = term.getName();
            // 此处需要的是 “全字匹配” ，让 word 能够独立成词，才要查找出来，而不是只作为词的一部分
            // 此处的 “全字匹配” 的实现不算特别严谨，更严谨的做法，可以使用正则表达式
            content = content.toLowerCase().replaceAll("\\b" + word + "\\b", " " + word + " ");
            firstPos = content.toLowerCase().indexOf(" " + word + " ");
            if (firstPos >= 0) {
                // 找到了位置
                break;
            }
        }
        if (firstPos == -1) {
            // 所有的分词结果都不在正文中
            // 属于比较极端的情况
            // 可以直接读取正文的前160字符作为描述
            if (content.length() > 160) {
                return content.substring(0, 160) + "...";
            }
            return content;
        }
        // 从 firstPos 作为基准，往前找 60 个字符，作为描述的起始位置
        String desc = "";
        int descBeg = firstPos > 60 ? firstPos - 60 : 0;
        if (descBeg + 160 > content.length()) {
            desc = content.substring(descBeg);
        } else {
            desc = content.substring(descBeg, descBeg + 160) + "...";
        }

        // 在此处加上一个替换操作，把描述中的和分词结果相同的部分，给加上一层 <i> 标签
        // 就可以通过 replace 的方式来实现。
        for (Term term : terms) {
            String word = term.getName();
            // 此处要进行全字匹配，即查询词为List的时候，不能把 ArrayList 中的 List 单独标红
            // 其中 (?i) 代表不区分大小写进行匹配
            desc = desc.replaceAll("(?i) " + word + " ", "<i> " + word + " </i>");
        }
        return desc;
    }
}
