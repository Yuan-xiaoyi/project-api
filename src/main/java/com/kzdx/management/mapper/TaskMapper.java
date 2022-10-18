package com.kzdx.management.mapper;

import com.kzdx.management.entity.Summarize;
import com.kzdx.management.entity.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskMapper {

    //查找所有任务
    List<Task> findTaskBySelection(List<String> projectIDs,Integer state,String createTime,String taskName,String isTask );

    //根据项目ID查找任务
    @Select("select * from task where project_id=#{projectId} order by state asc,deadline asc")
    List<Task>  findTaskByProjectId(String projectId);


    //新增任务
    @Insert("""
            insert into task(task_id,task_name,details,create_person,create_time,deadline,state,project_id,istask)
                        values(#{t.taskId},#{t.taskName},#{t.details},#{t.createPerson},#{t.createTime},#{t.deadline},#{t.state},#{p},#{t.isTask})
            """)
    Integer addTask(@Param("t") Task task, @Param("p") String projectId);

   //删除任务
    @Delete("""
            delete from task where task_id=#{taskId}
            """)
    Integer deleteTask(String taskId);

    //修改任务

    @Update("""
             update task set over_time=#{overTime},state=#{state},solve_details=#{solveDetails} where task_id=#{taskId}
            """)
    Integer updateTask(Task task);


    //根据taskID查找任务详情
    @Select("""
            select * from task where task_id=#{taskId}
            """)
    Task findByTaskId(String taskId);

}
