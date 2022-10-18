package com.kzdx.management;

import com.kzdx.management.entity.User;
import com.kzdx.management.mapper.UserMapper;
import com.kzdx.management.service.LoginService;
import com.kzdx.management.util.Bv;
//import com.kzdx.management.util.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
public class TestUser {
/*

    @Autowired
    UserMapper userMapper;
    @Autowired
    SendMessage sendMessage;

    @Autowired
    LoginService loginService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test1(){
        User user = new User();
        user.setUserName("张三");
        user.setPhoneNumber("19923218988");
        user.setPost("研发工程师");
        user.setStatus(0);
        userMapper.insert(user);

    }

    @Test
    public void test2(){
        List<User> userList = userMapper.findUser();

        for (User user:userList) {

            System.out.println(user.toString());

        }

    }

    @Test
    public void test3(){

        String id = String.valueOf(System.currentTimeMillis());
        System.out.println(id);
    }

    @Test
    public void test4() throws Exception {
    }
*/



}
