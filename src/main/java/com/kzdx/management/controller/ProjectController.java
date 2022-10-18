package com.kzdx.management.controller;

import com.kzdx.management.entity.Project;
import com.kzdx.management.entity.ProjectMember;
import com.kzdx.management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    //新增项目
    @RequestMapping("/addProject")
    @ResponseBody
    public HashMap<String,String> addProject(@RequestBody Project project){
       return projectService.addProject(project);
    }

    //查找所有项目,高级查询
    @RequestMapping("/findProjectBySelection")
    @ResponseBody
    public List<Project> findProjectBySelection(@RequestParam(required = false)String projectName,
                                                @RequestParam(required = false)Integer state,
                                                @RequestParam(required = false)String createTime,
                                                @RequestParam(required = false)String industry,
                                                @RequestParam(required = false)String post,
                                                @RequestParam(required = false)String userId){

       return projectService.findProjectBySelection(projectName,state,createTime,industry,post,userId);
    }

  //根据项目ID查找项目
    @RequestMapping("/findProjectById")
    @ResponseBody
    public Project findProjectById(@RequestParam String projectId){

       return projectService.findProjectById(projectId);

    }

   //修改项目信息
   @RequestMapping("/updateProject")
    public HashMap<String,String> updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }

    //删除项目信息
    @RequestMapping("/deleteProject")
    public HashMap<String,String> deleteProject(@RequestParam String projectId){
        return projectService.deleteProject(projectId);
    }

    //新增项目成员
    @RequestMapping("/addProjectMember")
    @ResponseBody
   public HashMap<String,String> addProjectMember(@RequestParam(required = false) String role,@RequestParam(required = false) String projectId, @RequestParam(required = false) String userId){
            return  projectService.addProjectMember(role,projectId,userId);
   }

    //删除项目成员
    @RequestMapping("/deleteProjectMember")
    @ResponseBody
    public void deleteProjectMember(@RequestParam(required = false) int projectMemberId){
        projectService.deleteProjectMember(projectMemberId);
    }

    //查找项目成员
    @RequestMapping("/findProjectMember")
    @ResponseBody
    public List<ProjectMember> findProjectMember(@RequestParam String projectId){
        return projectService.findProjectMember(projectId);
    }

    @RequestMapping("/findProjectByUserId")
    @ResponseBody
    public List<ProjectMember> findProjectByUserId(@RequestParam String userId){
        return projectService.findProjectByUserId(userId);
    }

}
