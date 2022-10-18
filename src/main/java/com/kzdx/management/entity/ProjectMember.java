package com.kzdx.management.entity;

public class ProjectMember {
    private int projectMemberId;
    private String userName;
    private String userId;
    private String projectId;
    private String role;

    public ProjectMember() {
    }

    public ProjectMember(int projectMemberId, String userName, String userId, String projectId, String role) {
        this.projectMemberId = projectMemberId;
        this.userName = userName;
        this.userId = userId;
        this.projectId = projectId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProjectMemberId() {
        return projectMemberId;
    }

    public void setProjectMemberId(int projectMemberId) {
        this.projectMemberId = projectMemberId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
