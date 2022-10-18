package com.kzdx.management.mapper;

import com.kzdx.management.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //新增用户
    @Insert("""
             insert into user(user_id,user_name,phone_number,post,status) 
             values(#{userId},#{userName},#{phoneNumber},#{post},#{status})
            """)
    Integer insert(User user);


    //查找所有用户
    @Select(" select user_id,user_name,phone_number,post,status from user")
    List<User> findUser();

    //根据姓名查找用户
    @Select(" select user_id,user_name,phone_number,post,status from user where user_name=#{userName}")
    User findUserByName(String userName);

    //根据电话号码查找用户
    @Select(" select user_id,user_name,phone_number,post,status from user where phone_number=#{phoneNumber}")
    User findUserByPhoneNumber(String phoneNumber);

    //根据id码查找用户
    @Select(" select user_id,user_name,phone_number,post,status from user where user_id=#{userId}")
    User findUserByUserId(String userId);

    //修改用户信息
    @Update("update user set user_name=#{userName}, phone_number=#{phoneNumber},post=#{post} where user_id=#{userId}")
    void updateUser(User user);

    //删除用户信息
    @Delete("delete from user where user_id=#{userId}")
    void delete(String userId);

}
