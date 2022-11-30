package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Blog {
    private Integer blogId;
    private String title;
    private String content;
    private Integer userId;
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // 把这个方法魔改下，在方法里面把时间戳构造成格式化时间，以 String 的方式来返回。
    public String getPostTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }

    public void setPostTime(Timestamp datetime) {
        this.postTime = datetime;
    }
}
