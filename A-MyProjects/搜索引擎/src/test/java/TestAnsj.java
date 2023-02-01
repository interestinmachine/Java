import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestAnsj {
    public static void main(String[] args) {
        String str = "小米比白米有更多的微量营养，小米取代白米不但有助控制血糖，而且可以有助逆转糖尿病，降低血脂，改善血压和降低心血管风险。";

        List<Term> terms = ToAnalysis.parse(str).getTerms();
        for (Term term : terms) {
            System.out.println(term);
        }
    }
}
