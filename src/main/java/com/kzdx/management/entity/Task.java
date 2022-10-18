package com.kzdx.management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class Task {
    private String taskId;//任务ID
    private String taskName;//任务名
    private String details;//任务详情
    private String createPerson;//创建人
    private LocalDateTime createTime;//创建时间
    private LocalDateTime overTime;//任务结束时间
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;//要求任务完成时间
    private int state;//任务最终状态 0：未完结，2：已完结

    private String projectId;


    private String handPerson;//处理人

    private String projectName;

    private String solveDetails;

    private int isTask;

    private List<TaskRecord> taskRecordList;//多个任务列表

    public Task() {
    }

    public Task(String taskId, String taskName, String details, String createPerson, LocalDateTime createTime, LocalDateTime overTime, LocalDateTime deadline, int state, String projectId, String handPerson, String projectName, String solveDetails, int isTask, List<TaskRecord> taskRecordList) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.details = details;
        this.createPerson = createPerson;
        this.createTime = createTime;
        this.overTime = overTime;
        this.deadline = deadline;
        this.state = state;
        this.projectId = projectId;
        this.handPerson = handPerson;
        this.projectName = projectName;
        this.solveDetails = solveDetails;
        this.isTask = isTask;
        this.taskRecordList = taskRecordList;
    }

    public String getHandPerson() {
        return handPerson;
    }

    public void setHandPerson(String handPerson) {
        this.handPerson = handPerson;
    }

    public int getIsTask() {
        return isTask;
    }

    public void setIsTask(int isTask) {
        this.isTask = isTask;
    }

    public String getSolveDetails() {
        return solveDetails;
    }

    public void setSolveDetails(String solveDetails) {
        this.solveDetails = solveDetails;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<TaskRecord> getTaskRecordList() {
        return taskRecordList;
    }

    public void setTaskRecordList(List<TaskRecord> taskRecordList) {
        this.taskRecordList = taskRecordList;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getOverTime() {
        return overTime;
    }

    public void setOverTime(LocalDateTime overTime) {
        this.overTime = overTime;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
