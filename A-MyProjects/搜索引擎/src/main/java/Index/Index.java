package Index;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DocInfo;
import model.Weight;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {

    // 设置索引结构保存到磁盘的路径
    private static final String INDEX_PATH = "E:\\Coding\\Java\\";

    private ObjectMapper objectMapper = new ObjectMapper();

    private final Object locker1 = new Object(); // 针对 ArrayList<model.DocInfo> forwardIndex 进行加锁
    private final Object locker2 = new Object(); // 针对 HashMap<String, ArrayList<model.Weight>> invertedIndex 进行加锁

    // 使用数组下标表示 docId
    private ArrayList<DocInfo> forwardIndex = new ArrayList<>();

    // 使用哈希表来表示倒排索引
    // key 为 词
    // value 为一组和这个词关联的文档
    private HashMap<String, ArrayList<Weight>> invertedIndex = new HashMap<>();

    // 1. 给定一个 docId，在正排索引中，查询文档的详细信息
    public DocInfo getDocInfo(int docId) {
        return forwardIndex.get(docId);
    }

    // 2. 给定一个词，在倒排索引中，查哪些文档和这个词关联
    // 因为 文档和词之间存在一定的相关性，所以返回值应和权重有关
    public List<Weight> getInverted(String term) {
        return invertedIndex.get(term);
    }

    // 3. 往索引中新增一个文档
    public void addDoc(String title, String url, String content) {
        // 新增文档操作，需要同时给正排索引和倒排索引新增信息
        // 构建正排索引
        DocInfo docInfo = buildForward(title, url, content);
        // 构建倒排索引
        buildInverted(docInfo);
    }

    private void buildInverted(DocInfo docInfo) {
        class WordCount {
            // 词在标题中出现的次数
            public int titleCount;
            // 词在正文中出现的次数
            public int contentCount;
        }

        HashMap<String, WordCount> wordCntHashMap = new HashMap<>();

        // 1. 针对文档标题进行分词
        List<Term> terms = ToAnalysis.parse(docInfo.getTitle()).getTerms();

        // 2. 遍历分词结果，统计每个词出现的次数
        for (Term term : terms) {
            // 判断 term 是否存在
            String word = term.getName();
            WordCount wordCount = wordCntHashMap.get(word);
            if (wordCount == null) {
                // 如果不存在，就创建一个新的键值对，插入进去，titleCount设为 1
                WordCount wordCount1 = new WordCount();
                wordCount1.titleCount = 1;
                wordCount1.contentCount = 0;
                wordCntHashMap.put(word, wordCount1);
            } else {
                wordCount.titleCount += 1;
            }
        }

        // 3. 针对正文进行分词
        terms = ToAnalysis.parse(docInfo.getContent()).getTerms();
        // 4. 遍历分词结果，统计每个词出现的次数
        for (Term term : terms) {
            String word = term.getName();
            WordCount wordCount = wordCntHashMap.get(word);
            if (wordCount == null) {
                // 如果不存在，就创建一个新的键值对，插入进去，contentCount设为 1
                WordCount wordCount1 = new WordCount();
                wordCount1.titleCount = 0;
                wordCount1.contentCount = 1;
                wordCntHashMap.put(word, wordCount1);
            } else {
                wordCount.contentCount += 1;
            }
        }
        // 5. 把上面的结果汇总到一个 HashMap 里面
        //      最终文档的权重，就设定成 标题中出现的次数*10 + 正文中出现的次数
        // 6. 遍历刚才的 HashMap，依次来更新倒排索引中的结构了
        for (Map.Entry<String, WordCount> entry : wordCntHashMap.entrySet()) {
            // 先根据这里的词，去倒排索引中查一查
            // 倒排拉链
            synchronized (locker2) {
                List<Weight> invertedList = invertedIndex.get(entry.getKey());
                if (invertedList == null) {
                    // 如果为空，就插入一个新的键值对
                    ArrayList<Weight> newInvertedList = new ArrayList<>();
                    // 把新的文档（当前的 model.DocInfo)，构造成 model.Weight 对象，插入进来
                    Weight weight = new Weight();
                    weight.setDocId(docInfo.getDocId());
                    // 权重计算公式，标题中出现的次数*10 + 正文中出现的次数
                    weight.setWeight(entry.getValue().titleCount * 10 + entry.getValue().contentCount);
                    newInvertedList.add(weight);
                    invertedIndex.put(entry.getKey(),newInvertedList);
                } else {
                    // 如果非空，就把当前这个文档，构造出一个 model.Weight 对象，插入到倒排拉链的后面
                    Weight weight = new Weight();
                    weight.setDocId(docInfo.getDocId());
                    weight.setWeight(entry.getValue().titleCount * 10 + entry.getValue().contentCount);
                    invertedList.add(weight);
                }
            }
        }
    }

    private DocInfo buildForward(String title, String url, String content) {
        DocInfo docInfo = new DocInfo();
        docInfo.setTitle(title);
        docInfo.setUrl(url);
        docInfo.setContent(content);
        synchronized (locker1) {
            docInfo.setDocId(forwardIndex.size());
            forwardIndex.add(docInfo);
        }
        return docInfo;
    }

    // 4. 把内存中的索引结构保存到磁盘中
    public void save() {
        long start = System.currentTimeMillis();
        System.out.println("开始保存索引！");
        // 1. 判定索引对应的目录是否存在，不存在就创建
        File indexPathFile = new File(INDEX_PATH);
        if (!indexPathFile.exists()) {
            indexPathFile.mkdirs();
        }
        File forwardIndexFile = new File(INDEX_PATH + "forward.txt");
        File invertedIndexFile = new File(INDEX_PATH + "inverted.txt");
        try {
            objectMapper.writeValue(forwardIndexFile,forwardIndex); // 保存正排索引
            objectMapper.writeValue(invertedIndexFile,invertedIndex); // 保存倒排索引
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("保存索引完成！耗时：" + (end-start) + " ms");
    }

    // 5. 把磁盘中的索引结构加载到内存
    public void load() {
        System.out.println("加载索引开始！");
        // 1. 设置加载索引的路径
        File forwardIndexFile = new File(INDEX_PATH + "forward.txt");
        File invertedIndexFile = new File(INDEX_PATH + "inverted.txt");
        try {
            forwardIndex = objectMapper.readValue(forwardIndexFile, new TypeReference<ArrayList<DocInfo>>() {});
            invertedIndex = objectMapper.readValue(invertedIndexFile, new TypeReference<HashMap<String, ArrayList<Weight>>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("加载索引结束！");
    }
}
