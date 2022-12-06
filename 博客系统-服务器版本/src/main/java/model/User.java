package model;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private int isYourBlog = 0;

    public int getIsYourBlog() {
        return isYourBlog;
    }

    public void setIsYourBlog(int isYourBlog) {
        this.isYourBlog = isYourBlog;
    }





    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
