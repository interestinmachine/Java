import Searcher.DocSearcher;
import Searcher.Result;

import java.util.List;
import java.util.Scanner;

public class TestSearcher {
    public static void main(String[] args) {
        DocSearcher docSearcher = new DocSearcher();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("-> ");
            String query = scanner.next();
            List<Result> results = docSearcher.search(query);
            for (Result result : results) {
                System.out.println("=======================");
                System.out.println(result);
            }
        }
    }
}
