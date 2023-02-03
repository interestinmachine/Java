import Index.Parser;

import java.io.File;

public class TestContent {
    public static void main(String[] args) {
        Parser parser = new Parser();
        File file = new File("E:\\Coding\\Java\\docs\\api\\java\\util\\AbstractCollection.html");
        String result1 = parser.parserContent(file);
        String result2 = parser.parserContentByRegex(file);
        System.out.println(result1);
        System.out.println(result2);
    }
}
