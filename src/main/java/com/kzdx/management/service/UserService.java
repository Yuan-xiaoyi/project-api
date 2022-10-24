package com.kzdx.management.service;

import com.kzdx.management.entity.User;
import com.kzdx.management.mapper.UserMapper;
import com.kzdx.management.util.Bv;
import com.kzdx.management.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    //新增用户
    public HashMap<String,String> insertUser(User user){
        HashMap<String,String> result=new HashMap<>();
        String userId = "user"+(System.currentTimeMillis());
        user.setUserId(userId);
        if(userMapper.findUserByPhoneNumber(user.getPhoneNumber())!=null){
            result.put("code","500");
            result.put("msg","此号码已经存在！");
            return result;
        }else {
            Integer res = userMapper.insert(user);
            if(res>0){
                result.put("msg","添加用户成功！");
                return result;
            }
            result.put("msg","添加失败！");
            return result;
        }

    }


    ////查找所有用户
    public List<User> findUser(){
        return userMapper.findUser();
    }

    ////根据姓名查找用户
    public User findUserByName(String userName){
        return userMapper.findUserByName(userName);
    }

    ////根据电话号码查找用户
    public User findUserByPhoneNumber(String phoneNumber){

        return userMapper.findUserByPhoneNumber(phoneNumber);
    }

    ////根据userId查找用户
    public User findUserByUserId(String UserId){

        return userMapper.findUserByUserId(UserId);
    }


    //修改用户信息
    public void updateUserinfo(User user){
        userMapper.updateUser(user);
    }

    //删除用户信息
    public void deleteUser(String userId){
        userMapper.delete(userId);
    }

}
