package com.kzdx.management.service;

import com.kzdx.management.entity.User;
import com.kzdx.management.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public User loginCheck( String phoneNumber, String code){

        //保存从Redis获取到的code
       String redisCode= redisTemplate.opsForValue().get(phoneNumber);
        //System.out.println(redisCode);
       User userinfo= userMapper.findUserByPhoneNumber(phoneNumber);
       if(code.equals(redisCode) && userinfo!=null){

           System.out.println("存在的号码是"+redisTemplate.opsForValue().get(phoneNumber));
           return userinfo;
       }
       return null;

    }

    public User loginCheckWx( String phoneNumber){


        User userinfo= userMapper.findUserByPhoneNumber(phoneNumber);
        if(userinfo!=null){

            return userinfo;
        }
        return null;

    }
}
