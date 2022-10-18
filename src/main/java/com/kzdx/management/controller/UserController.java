package com.kzdx.management.controller;

import com.kzdx.management.entity.User;
import com.kzdx.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //@RequestBody：负责把json对象解析成Java对象
    //  @ResponseBody：负责把Java对象转换成json对象
    //新增用户
    @RequestMapping("/insertUser")
    @ResponseBody
    public HashMap<String,String> insertUser(@RequestBody User user){

       return userService.insertUser(user);
    }
    //查找所有用户
    @RequestMapping("/findUser")
    @ResponseBody
    public List<User> findUser(){
        return userService.findUser();
    }

    //根据姓名查找用户
    @RequestMapping("/findUserByName/")
    @ResponseBody
    public User findUserByName(@RequestParam(required = false) String userName){
        return userService.findUserByName(userName);
    }

    //根据姓号码查找用户
    @RequestMapping("/findUserByPhoneNumber")
    @ResponseBody
    public User findUserByPhoneNumber(@RequestParam(required = false)String phoneNumber){
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    //根据Id查找用户
    @RequestMapping("/findUserByUserId")
    @ResponseBody
    public User findUserByUserId(@RequestParam(required = false)String userId){
        return userService.findUserByUserId(userId);
    }

    //修改用户信息
    @RequestMapping("/updateUserinfo")
    @ResponseBody
    public void updateUserinfo(User user){
        userService.updateUserinfo(user);
    }
    //删除用户信息
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam(required = false)String userId){
        userService.deleteUser(userId);
    }

}
