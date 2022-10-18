package com.kzdx.management;

import com.kzdx.management.entity.Project;
import com.kzdx.management.mapper.ProjectMapper;
import com.kzdx.management.util.Bv;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TestProject {

    @Autowired
    ProjectMapper projectMapper;
    @Test
    public void test(){
      /*  Project project = new Project();
        project.setProjectName("开州区智慧水库检测项目系统");
        project.setDetails("将全区所有中小型水库，进行数字化，智能化的管理");
        project.setIndustry("党政军");
        project.setState(0);
        project.setProprietor("开州区水利局");
        project.setMainManager("李某某");
        project.setFenManager("杨某某");
        project.setAgent("李某某");
        project.setCreateTime(LocalDateTime.now());
        projectMapper.addProject(project);*/
       // int id=projectMapper.lastInsertId();
        //String projectId= Bv.getProjectId(id);
       // projectMapper.updateId(projectId,id);
    }


}
