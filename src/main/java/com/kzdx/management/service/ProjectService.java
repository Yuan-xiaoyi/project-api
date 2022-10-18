package com.kzdx.management.service;

import com.kzdx.management.entity.Project;
import com.kzdx.management.entity.ProjectMember;
import com.kzdx.management.entity.Summarize;
import com.kzdx.management.mapper.ProjectMapper;
import com.kzdx.management.mapper.SummarizeMapper;
import com.kzdx.management.util.Bv;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectService {
    //获取当前时间（年、月、日、时、分、秒）
   //对象.setpublictime(LocalDataTime.now());

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    SummarizeMapper summarizeMapper;
    //新增项目（商机信息）
    public HashMap<String,String> addProject(Project project){
        String projectId = "pr"+String.valueOf(System.currentTimeMillis());
        //System.out.println(projectId);

        project.setProjectId(projectId);
        project.setCreateTime(LocalDateTime.now());
        Integer res = projectMapper.addProject(project);

        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","添加成功");
            return result;
        }
        result.put("msg","添加失败");
        return result;

    }

    //查找所有项目
    public List<Project> findProjectBySelection(String projectName,Integer state,String createTime,String industry,String post,String userId){

        return  projectMapper.findProjectBySelection(projectName,state,createTime,industry,post,userId);
    }

    //根据ID查找项目
    public Project findProjectById(String bv){
        Project project = projectMapper.findProjectById(bv);
        if(project==null){
            return  null;
        }
        //查找项目阶段性总结
        List<Summarize> summarizeList=summarizeMapper.findSummarizeByProjectId(bv);
        project.setSummarizeList(summarizeList);

        return project;
    }


    //修改项目
    public HashMap<String,String> updateProject(Project project){
        Integer res = projectMapper.updateProject(project);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","修改成功！");
            return result;
        }
        result.put("msg","修改失败！");
        return result;
    }

    //删除项目
    public  HashMap<String,String> deleteProject(String projectId){
        Integer res = projectMapper.deleteProject(projectId);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","删除成功！");
            return result;
        }
        result.put("msg","删除失败！");
        return result;
    }

    //新增项目成员
    public HashMap<String,String> addProjectMember(String role, String projectId,String userId){

        Integer res = projectMapper.addProjectMember(role,projectId,userId);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","添加成功");
            return result;
        }
        result.put("msg","添加失败");
        return result;
    }

    //删除项目成员
    public HashMap<String,String> deleteProjectMember(int projectMemberId){

        Integer res = projectMapper.deleteProjectMember(projectMemberId);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","删除成功！");
            return result;
        }
        result.put("msg","删除失败！");
        return result;
    }
    //查找项目成员
    public  List<ProjectMember> findProjectMember(String projectId){

        List<ProjectMember> list = projectMapper.findProjectMember(projectId);

        return  list;


    }
    public  List<ProjectMember> findProjectByUserId(String userId){
        List<ProjectMember> list = projectMapper.findProjectByUserId(userId);
        return  list;
    }

}
