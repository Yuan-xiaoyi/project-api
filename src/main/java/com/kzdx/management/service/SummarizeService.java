package com.kzdx.management.service;

import com.kzdx.management.entity.Summarize;
import com.kzdx.management.mapper.SummarizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class SummarizeService {
    @Autowired
    SummarizeMapper summarizeMapper;
    //新增阶段总结
    public HashMap<String,String> addSummarize(Summarize summarize,String projectId){
        summarize.setCreateTime(LocalDateTime.now());
        Integer res=summarizeMapper.addSummarize(summarize,projectId);

        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","添加成功");


            return result;
        }
        result.put("msg","添加失败");
        return result;
    }

    //查找阶段性总结
    public List<Summarize> findSummarizeByProjectId(String projectId){
        return summarizeMapper.findSummarizeByProjectId(projectId);
    }

    //修改阶段性总结
    public  HashMap<String,String> updateSummarize(int id,String title,String details){
        Integer res=summarizeMapper.updateSummarize(id,title,details);
        HashMap<String,String> result=new HashMap<>();
        if(res>0){
            result.put("msg","修改成功");
            return result;
        }
        result.put("msg","修改失败");
        return result;
    }
}
