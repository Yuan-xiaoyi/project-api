package com.kzdx.management.controller;

import com.kzdx.management.entity.Project;
import com.kzdx.management.entity.Summarize;
import com.kzdx.management.service.SummarizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SummarizeController {

    @Autowired
    SummarizeService summarizeService;

    //新增阶段性总结
    @RequestMapping("/addSummarize")
    @ResponseBody
    public HashMap<String,String> addSummarize(@RequestBody Summarize summarize, @RequestParam String projectId){
        return  summarizeService.addSummarize(summarize,projectId);
    }

    //查找阶段性总结
    @RequestMapping("/findSummarizeByProjectId")
    @ResponseBody
    public List<Summarize> findSummarizeByProjectId(@RequestParam String projectId){
        return summarizeService.findSummarizeByProjectId(projectId);
    }

    //修改阶段性总结
    @RequestMapping("/updateSummarize")
    public HashMap<String,String> updateSummarize(@RequestParam int id,@RequestParam String title,@RequestParam String details){
        return summarizeService.updateSummarize(id,title,details);
    }
}
