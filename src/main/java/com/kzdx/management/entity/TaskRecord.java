package com.kzdx.management.entity;

import java.time.LocalDateTime;

public class TaskRecord {
    private String recordId;
    private String handPersonId;
    private String userName;//任务处理人
    private int state;//当前任务状态，0:待处理，1：待审核，2：已完结，3：退回
    private LocalDateTime createTime;//创建时间
    private LocalDateTime overTime;//任务结束时间
    private String solveDetails;//处理情况
    private String checkDetails;//审核情况
    private String taskId;
    private String checkPersonId;

    public TaskRecord() {
    }




    public TaskRecord(String recordId, String handPersonId, String userName, int state, LocalDateTime createTime, LocalDateTime overTime, String solveDetails, String checkDetails, String taskId, String checkPersonId) {
        this.recordId = recordId;
        this.handPersonId = handPersonId;
        this.userName = userName;
        this.state = state;
        this.createTime = createTime;
        this.overTime = overTime;
        this.solveDetails = solveDetails;
        this.checkDetails = checkDetails;
        this.taskId = taskId;
        this.checkPersonId = checkPersonId;
    }

    public String getCheckPersonId() {
        return checkPersonId;
    }

    public void setCheckPersonId(String checkPersonId) {
        this.checkPersonId = checkPersonId;
    }

    public String getUserName() {
        return userName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getHandPersonId() {
        return handPersonId;
    }

    public void setHandPersonId(String handPersonId) {
        this.handPersonId = handPersonId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getSolveDetails() {
        return solveDetails;
    }

    public void setSolveDetails(String solveDetails) {
        this.solveDetails = solveDetails;
    }

    public String getCheckDetails() {
        return checkDetails;
    }

    public void setCheckDetails(String checkDetails) {
        this.checkDetails = checkDetails;
    }
}
