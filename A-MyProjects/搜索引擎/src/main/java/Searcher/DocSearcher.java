package Searcher;

import Index.Index;
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
        return null;
    }
}
