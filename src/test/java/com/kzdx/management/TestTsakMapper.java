package com.kzdx.management;

import com.kzdx.management.entity.Task;
import com.kzdx.management.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestTsakMapper {
    @Autowired
    TaskMapper taskMapper;

  /*  public void test(){
        List<String> stringList=new ArrayList<>();
        stringList.add("pr1663499543239");
        stringList.add("pr1663749961019");
        stringList.add("pr1663820290714");
        List<Task> tasks=taskMapper.findTaskBySelection(stringList,null,null,null);
        System.out.println(tasks.size());

    }*/
}
