package Searcher;

import Index.Index;
import model.DocInfo;
import model.Weight;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DocSearcher {

    private Index index = new Index();

    public DocSearcher() {
        index.load();
    }

    // 完成整个搜索过程的方法
    // 参数（输入部分）用户给出的查询词
    // 返回值（输出部分）搜索结果的集合
    public List<Result> search(String query) {
        // 1.【分词】针对 query 查询词进行分词
        List<Term> terms = ToAnalysis.parse(query).getTerms();
        // 2.【触发】针对分词结果来查倒排
        List<Weight> allTermResult = new ArrayList<>();
        for (Term term : terms) {
            String word = term.getName();
            List<Weight> invertedList = index.getInverted(word);
            if (invertedList == null) {
                // 说明这个查询词在所有文档中都不存在
                continue;
            }
            allTermResult.addAll(invertedList);
        }
        // 3.【排序】针对触发结果按照权重降序排序
        allTermResult.sort(new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return o2.getWeight() - o1.getWeight();
            }
        });
        // 4.【包装结果】针对排序的结果，查正排，构造出要返回的数据
        List<Result> results = new ArrayList<>();
        for (Weight weight:allTermResult) {
            DocInfo docInfo = index.getDocInfo(weight.getDocId());
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setUrl(docInfo.getUrl());
            result.setDesc(GenDesc(docInfo.getContent(),terms));
            results.add(result);
        }
        return results;
    }

    private String GenDesc(String content, List<Term> terms) {
        // 先遍历分词结果，看看哪个结果在 content 中存在
        int firstPos = -1;
        for (Term term:terms) {
            // 分词库直接针对词进行转小写了
            // 正因为如此，就必须把正文内容也先转为小写，然后再查询
            String word = term.getName();
            // 此处需要的是 “全字匹配” ，让 word 能够独立成词，才要查找出来，而不是只作为词的一部分
            // 此处的 “全字匹配” 的实现不算特别严谨，更严谨的做法，可以使用正则表达式
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
            return content.substring(0,160) + "...";
        }
        // 从 firstPos 作为基准，往前找 60 个字符，作为描述的起始位置
        String desc = "";
        int descBeg = firstPos > 60 ? firstPos-60:0;
        if (descBeg+160 > content.length()) {
            desc = content.substring(descBeg);
        } else {
            desc = content.substring(descBeg,descBeg+160) + "...";
        }

        // 在此处加上一个替换操作，把描述中的和分词结果相同的部分，给加上一层 <i> 标签
        // 就可以通过 replace 的方式来实现。
        for (Term term :terms) {
            String word = term.getName();
            // 此处要进行全字匹配，即查询词为List的时候，不能把 ArrayList 中的 List 单独标红
            // 其中 (?i) 代表不区分大小写进行匹配
            desc = desc.replaceAll("(?i) " + word + " ","<i> " + word + " </i>");
        }
        return desc;
    }
}
