package com.kzdx.management.service;

import com.kzdx.management.entity.Task;
import com.kzdx.management.entity.TaskRecord;
import com.kzdx.management.entity.User;
import com.kzdx.management.mapper.TaskRecordMapper;
import com.kzdx.management.mapper.TaskMapper;
import com.kzdx.management.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TaskRecordService {
    @Autowired
    TaskRecordMapper taskRecordMapper;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserService userService;
    @Autowired
     SendSms sendSms;
    //添加任务执行记录
    public HashMap<String,String> addTaskRecord(TaskRecord taskRecord) throws Exception {

        String recordId = "tare"+String.valueOf(System.currentTimeMillis());

        taskRecord.setRecordId(recordId);
        taskRecord.setCreateTime(LocalDateTime.now());
        taskRecord.setState(0);
        Integer res =  taskRecordMapper.addTaskRecord(taskRecord);

        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            //----------发送通知短信----------
            //获取任务处理人ID
           TaskRecord ta = taskRecordMapper.findTaskRecordByRecordId(taskRecord.getRecordId());
           String userId=ta.getHandPersonId();
            //获取任务处理人的手机号码
            User user= userService.findUserByUserId(userId);
            String telephone = user.getPhoneNumber();
            //调用发送短信接口
            sendSms.send(telephone,"SMS_256930110");

            result.put("msg","添加成功");
            return result;
        }
        result.put("msg","添加失败");
        return result;
    }

    //修改任务执行记录
    public HashMap<String,String> updateTaskRecord(TaskRecord taskRecord) throws Exception {

        taskRecord.setOverTime(LocalDateTime.now());
        Integer res =  taskRecordMapper.updateTaskRecord(taskRecord);

        HashMap<String,String> result=new HashMap<>();
        if(res>0){

            if(taskRecord.getState()==1){
                //----------发送通知短信----------
                //获取任务审批人ID
                TaskRecord ta = taskRecordMapper.findTaskRecordByRecordId(taskRecord.getRecordId());
                //获取任务审批人的手机号码
                User user= userService.findUserByUserId(ta.getCheckPersonId());
                String telephone = user.getPhoneNumber();
                //调用发送短信接口
                sendSms.send(telephone,"SMS_256930110");
            }
            result.put("msg","修改成功");
            return result;
        }
        result.put("msg","修改失败");
        return result;
    }

    //删除执行记录
    public HashMap<String,String> deleteTaskRecord(String taskId){
        Integer res =  taskRecordMapper.deleteTaskRecord(taskId);

        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","删除成功");
            return result;
        }
        result.put("msg","删除失败");
        return result;
    }

    //根据任务ID查找任务记录
    public List<TaskRecord> findTaskRecordByTaskId(String taskId){
       return taskRecordMapper.findTaskRecordByTaskId(taskId);
    }

    //根据任务记录ID查找任务记录
    public TaskRecord findTaskRecordByRecordId(String recordId){
        return taskRecordMapper.findTaskRecordByRecordId(recordId);
    }



    //根据用户ID查找待办任务
    public List<TaskRecord>  backlogFindByUserId(String userId){
        return taskRecordMapper.backlogFindByUserId(userId);
    }

    //根据用户ID查找已办任务
    public List<TaskRecord>  finishedFindByUserId(String userId){
        return taskRecordMapper.finishedFindByUserId(userId);
    }

    //根据用户ID查询按时完成任务情况
    public List<Task> inTimeByUserId(String userId){
        return taskRecordMapper.inTimeByUserId(userId);
    }

    //根据用户ID查询任务被退回情况
    public List<TaskRecord>  setBackByUserId(String userId){
        return taskRecordMapper.setBackByUserId(userId);
    }


}
