package com.kzdx.management.entity;

import java.time.LocalDateTime;

public class Summarize {

    private int id;

    private String title;//标题
    private String details;//总结详情
    private LocalDateTime createTime;//创建时间

    public Summarize() {
    }

    public Summarize(int id,String title, String details, LocalDateTime createTime) {
        this.id=id;
        this.title = title;
        this.details = details;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
