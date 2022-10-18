package com.kzdx.management.service;

import com.kzdx.management.entity.Task;
import com.kzdx.management.mapper.TaskMapper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper;

    //新增任务
    public String addTask(Task task,String projectId){
        String taskId = "ta"+String.valueOf(System.currentTimeMillis());
        //System.out.println(projectId);

        task.setTaskId(taskId);
        task.setState(0);
        task.setCreateTime(LocalDateTime.now());
        Integer res = taskMapper.addTask(task, projectId);

        if(res>0){
            return task.getTaskId();
        }
        return null;
    }

    //根据projectId查找任务
    public List<Task>  findTaskByProjectId(String projectId){
        List<Task>  res=taskMapper.findTaskByProjectId(projectId);
        if (res ==null){
            return null;
        }
        return  res;
    }

    //查找任务
    public List<Task> findTaskBySelection(List<String> projectIDs, Integer state, String createTime, String taskName,String isTask ){

        return taskMapper.findTaskBySelection(projectIDs, state, createTime, taskName,isTask);


       /* if(projectIDs.length>0) {
            List<String> stringList = Arrays.asList(projectIDs);

            return taskMapper.findTaskBySelection(stringList, state, createTime, taskName);
        }
        else{
         return  null;
        }
        */

    }

    //修改任务
    public HashMap<String,String> updateTask(Task task){


        task.setOverTime(LocalDateTime.now());
        Integer res =  taskMapper.updateTask(task);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","修改成功！");
            return result;
        }
        result.put("msg","修改失败！");
        return result;
    }

    //删除任务
    public HashMap<String,String> deleteTask(String taskId){
        Integer res = taskMapper.deleteTask(taskId);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","删除成功！");
            return result;
        }
        result.put("msg","删除失败！");
        return result;
    }

    //根据taskID查找任务详情
    public Task findByTaskId(String taskId){
       return taskMapper.findByTaskId(taskId);
    }

}
