package com.kzdx.management.entity;

public class User {

    private String userId;
    private String userName;
    private String phoneNumber;//手机号码
    private String post;//职位
    private int status;//身份标识


    public User(String userId, String userName, String phoneNumber, String post, int status) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.post = post;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", post='" + post + '\'' +
                ", status=" + status +
                '}';
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
