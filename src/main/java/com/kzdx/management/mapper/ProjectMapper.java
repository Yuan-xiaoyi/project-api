package com.kzdx.management.mapper;

import com.kzdx.management.entity.Project;
import com.kzdx.management.entity.ProjectMember;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {


    //新增项目

   Integer addProject(Project project);



    //查询所有项目
    List<Project> findProjectBySelection(String projectName,Integer state,String createTime,String industry,String post,String userId);

    //根据Id查项目
    @Select("""
            select project_id,project_name,create_time,details,industry,state,proprietor,main_manager,fen_manager,agent,important,bidding,significance
            from project where project_id=#{projectId}
            """)
   Project findProjectById(String projectId);


    //修改项目
    @Update("update project set project_name=#{projectName},details=#{details},industry=#{industry},state=#{state},proprietor=#{proprietor},main_manager=#{mainManager},fen_manager=#{fenManager},agent=#{agent},important=#{important},bidding=#{bidding},significance=#{significance} where project_id=#{projectId}")
   Integer updateProject(Project project);

    //删除项目
    @Update("delete from project where project_id=#{projectId}")
    Integer deleteProject(String projectId);




    //添加项目成员
    @Insert("""
            insert into project_member(role,project_id,user_id)
            values(#{role},#{projectId},#{userId})
            """)
    Integer addProjectMember(@Param("role") String role,@Param("projectId") String projectId,@Param("userId") String userId);

    //删除项目成员
    @Delete("delete from project_member where project_member_id=#{projectMemberId}")
    Integer deleteProjectMember(int projectMemberId);

    //查找项目成员

   @Select("""
            select project_member_id,role,project_id,u.user_name,u.user_id
            from project_member p
            left join user u on p.user_id=u.user_id
                where project_id=#{projectId}
               """)
   List<ProjectMember> findProjectMember(String projectId);

    @Select("""
            select * from project_member where user_id=#{userId}
               """)
    List<ProjectMember> findProjectByUserId(String userId);

}
