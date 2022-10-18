package com.kzdx.management.mapper;

import com.kzdx.management.entity.Summarize;
import com.kzdx.management.entity.Task;
import com.kzdx.management.entity.TaskRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskRecordMapper {
    //添加任务执行记录

    @Insert("""
            insert into task_record(record_id,hand_person_id,state,create_time,solve_details,task_id,check_person_id) 
            values(#{recordId},#{handPersonId},#{state},#{createTime},#{solveDetails},#{taskId},#{checkPersonId})
            """)
    Integer addTaskRecord(TaskRecord taskRecord);


    //修改执行记录
    @Update("""
            update task_record set state=#{state},over_time=#{overTime},solve_details=#{solveDetails},check_details=#{checkDetails} where record_id=#{recordId}
            """)
    Integer updateTaskRecord(TaskRecord taskRecord);

    //根据任务ID查找任务记录
    @Select("select t.record_id,t.hand_person_id,u.user_name,t.state,t.create_time,t.over_time,t.solve_details,t.check_details,t.task_id,t.check_person_id " +
            "from task_record t left join user u on t.hand_person_id=u.user_id  where t.task_id=#{taskId}")
    List<TaskRecord> findTaskRecordByTaskId(String taskId);

    //根据任务记录ID查找任务记录
    @Select("select t.record_id,t.hand_person_id,u.user_name,t.state,t.create_time,t.over_time,t.solve_details,t.check_details,t.task_id,t.check_person_id " +
            "from task_record t left join user u on t.hand_person_id=u.user_id  where t.record_id=#{recordId}")
    TaskRecord findTaskRecordByRecordId(String recordId);

    //删除记录
    @Delete("""
            delete from task_record where task_id=#{taskId}
            """)
    Integer deleteTaskRecord(String taskId);

    //根据用户ID查找待办任务
    @Select("""
            select * from task_record where hand_person_id=#{userId} and state=0
            union 
            select * from task_record where check_person_id=#{userId} and state=1
            """)
    List<TaskRecord>   backlogFindByUserId(String userId);

    //根据用户ID查找已办任务
    @Select("""
            select * from task_record where hand_person_id=#{userId} and state!=0
            union 
            select * from task_record where check_person_id=#{userId} and state!=1
            """)
    List<TaskRecord>  finishedFindByUserId(String userId);

    @Select("""
            select * from task t left join task_record tr on t.task_id=tr.task_id 
            where tr.hand_person_id=#{userId} and t.istask = 1
            """)
    List<Task> inTimeByUserId(String userId);

    @Select("""
            select * from task_record where hand_person_id=#{userId}
            """)
    List<TaskRecord> setBackByUserId(String userId);
}


