package com.kzdx.management.mapper;

import com.kzdx.management.entity.Project;
import com.kzdx.management.entity.Summarize;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SummarizeMapper {
    //查找所有阶段总结详情
    @Select("select id,title,details,create_time,project_id from summarize")
    List<Summarize> findAllSummarize();

    //根据项目ID查找总结
    @Select("select id,title,details,create_time from summarize where project_id=#{projectId}")
   List<Summarize> findSummarizeByProjectId(String projectId);


    //新增阶段性总结
    @Insert("""
            insert into summarize(title,details,create_time,project_id)
                        values(#{s.title},#{s.details},#{s.createTime},#{p})
            """)
    Integer addSummarize(@Param("s") Summarize summarize, @Param("p") String projectId);


    //修改总结
    @Update("update summarize set title=#{t}, details=#{d} where id=#{id}")
    Integer updateSummarize(@Param("id")int id,@Param("t")String title,@Param("d")String details);
}
