package com.kzdx.management.controller;

import com.kzdx.management.entity.Task;
import com.kzdx.management.entity.TaskRecord;
import com.kzdx.management.service.TaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class TaskRecordController {
    @Autowired
    TaskRecordService taskRecordService;


    //添加任务执行记录
    @RequestMapping("/addTaskRecord")
    @ResponseBody
    public HashMap<String,String> addTaskRecord(@RequestBody TaskRecord taskRecord) throws Exception {
        return taskRecordService.addTaskRecord(taskRecord);
    }

    //修改执行记录
    @RequestMapping("/updateTaskRecord")
    @ResponseBody
    public HashMap<String,String> updateTaskRecord(@RequestBody TaskRecord taskRecord) throws Exception {
        return taskRecordService.updateTaskRecord(taskRecord);
    }

    //删除执行记录
    @RequestMapping("/deleteTaskRecord")
    @ResponseBody
    public HashMap<String,String> deleteTaskRecord(@RequestParam String taskId){
        return taskRecordService.deleteTaskRecord(taskId);
    }

    //查询任务记录
    @RequestMapping("/findTaskRecordByTaskId")
    @ResponseBody
    public List<TaskRecord> findTaskRecordByTaskId(@RequestParam String taskId){
        return taskRecordService.findTaskRecordByTaskId(taskId);
    }

    ////根据用户ID查找待办任务
    @RequestMapping("/backlogFindByUserId")
    @ResponseBody
    public List<TaskRecord>  backlogFindByUserId(@RequestParam String userId){
       return taskRecordService.backlogFindByUserId(userId);
    }

    ////根据用户ID查找已办任务
    @RequestMapping("/finishedFindByUserId")
    @ResponseBody
    public List<TaskRecord>  finishedFindByUserId(@RequestParam String userId){
        return taskRecordService.finishedFindByUserId(userId);
    }

    // 根据用户ID查询任务被退回情况
    @RequestMapping("/inTimeByUserId")
    @ResponseBody
    public List<Task> inTimeByUserId(@RequestParam String userId){
        return taskRecordService.inTimeByUserId(userId);
    }

    //根据用户ID查询任务被退回情况
    @RequestMapping("/setBackByUserId")
    @ResponseBody
    public List<TaskRecord> setBackByUserId(@RequestParam String userId){
        return taskRecordService.setBackByUserId(userId);
    }
}
