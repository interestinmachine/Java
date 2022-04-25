package CollectionExcise_;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new news("新冠确诊病例超千万，数百万印度教信徒赴恒河 \"圣浴\"引起民众担忧"));
        arrayList.add(new news("男子突然想起2个月前钓的鱼还在网兜里，捞起来一看赶紧放生"));

        int len = arrayList.size();
        for (int i = len -1; i >= 0; i--){
            news news = (news)arrayList.get(i);
            System.out.println(processTitle(news.getTitle()));
        }
    }

    public static String processTitle(String title){
        if (title == null){
            return "";
        }

        if (title.length() > 15) {
            return title.substring(0,15) + "...";
        } else {
            return title;
        }
    }
}

class news {
    private String title;
    private String content;

    public news(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "news{" +
                "title='" + title + '\'' +
                '}';
    }
}

