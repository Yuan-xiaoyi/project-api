package com.kzdx.management.controller;

import com.kzdx.management.entity.Task;
import com.kzdx.management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    //新增任务
    @RequestMapping("/addTask")
    @ResponseBody
    public String addTask(@RequestBody Task task, @RequestParam String projectId){
       return taskService.addTask(task,projectId);
    }

    //查找任务
    @RequestMapping("/findTaskByProjectId")
    @ResponseBody
    public List<Task> findTaskByProjectId(@RequestParam String projectId){

        return taskService.findTaskByProjectId(projectId);
    }

    //高级查找任务
    @RequestMapping("/findTaskBySelection")
    @ResponseBody
    public List<Task> findTaskBySelection(@RequestBody List<String> projectIDs,
                                          @RequestParam(required = false) Integer state,
                                          @RequestParam(required = false) String createTime,
                                          @RequestParam(required = false) String taskName,
                                          @RequestParam(required = false) String isTask){
        return taskService.findTaskBySelection(projectIDs, state, createTime, taskName,isTask);
    }
    //删除任务
    @RequestMapping("/deleteTask")
    @ResponseBody
    public HashMap<String,String>  deleteTask(@RequestParam String taskId){
        return  taskService.deleteTask(taskId);

    }

    //修改任务
    @RequestMapping("/updateTask")
    @ResponseBody
    public HashMap<String,String> updateTask(Task task){
        return taskService.updateTask(task);
    }

    //根据taskId查找任务详情
    @RequestMapping("/findByTaskId")
    @ResponseBody
    public Task findByTaskId(@RequestParam String taskId){
        return taskService.findByTaskId(taskId);
    }

}
