package com.kzdx.management.entity;

import java.time.LocalDateTime;
import java.util.*;

public class Project {
    private String projectId;//项目ID
    private String projectName;//项目名
    private LocalDateTime createTime;//创建时间
    private String details;//项目详情
    private String industry;//所属行业类别
    private Integer state;//项目状态
    private String proprietor;//项目业主
    private String mainManager;//项目主管领导
    private String fenManager;//分管领导
    private String agent;//项目经办人

    private String important;//项目经办人
    private String bidding;//是否我方中标

    private String significance;//重要性（星级）
    private List<Task> taskList;//多个任务
   private List<Summarize> summarizeList;//多个阶段总结

    public Project() {
    }


    public Project(String projectId, String projectName, LocalDateTime createTime, String details, String industry, Integer state, String proprietor, String mainManager, String fenManager, String agent, String important, String bidding, String significance, List<Task> taskList, List<Summarize> summarizeList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.createTime = createTime;
        this.details = details;
        this.industry = industry;
        this.state = state;
        this.proprietor = proprietor;
        this.mainManager = mainManager;
        this.fenManager = fenManager;
        this.agent = agent;
        this.important = important;
        this.bidding = bidding;
        this.significance = significance;
        this.taskList = taskList;
        this.summarizeList = summarizeList;
    }

    public String getSignificance() {
        return significance;
    }

    public void setSignificance(String significance) {
        this.significance = significance;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getProprietor() {
        return proprietor;
    }

    public void setProprietor(String proprietor) {
        this.proprietor = proprietor;
    }

    public String getMainManager() {
        return mainManager;
    }

    public void setMainManager(String mainManager) {
        this.mainManager = mainManager;
    }

    public String getFenManager() {
        return fenManager;
    }

    public void setFenManager(String fenManager) {
        this.fenManager = fenManager;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getBidding() {
        return bidding;
    }

    public void setBidding(String bidding) {
        this.bidding = bidding;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Summarize> getSummarizeList() {
        return summarizeList;
    }

    public void setSummarizeList(List<Summarize> summarizeList) {
        this.summarizeList = summarizeList;
    }

    public Project(String projectId, String projectName, LocalDateTime createTime, String details, String industry, Integer state, String proprietor, String mainManager, String fenManager, String agent, String bidding, List<Task> taskList, List<Summarize> summarizeList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.createTime = createTime;
        this.details = details;
        this.industry = industry;
        this.state = state;
        this.proprietor = proprietor;
        this.mainManager = mainManager;
        this.fenManager = fenManager;
        this.agent = agent;
        this.bidding = bidding;
        this.taskList = taskList;
        this.summarizeList = summarizeList;
    }
}
