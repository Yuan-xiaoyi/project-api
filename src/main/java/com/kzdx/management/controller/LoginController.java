package com.kzdx.management.controller;

import com.kzdx.management.entity.User;
import com.kzdx.management.service.LoginService;
import com.kzdx.management.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class LoginController {

  @Autowired
    LoginService loginService;
    //登录验证
    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,String> login(@RequestParam String phoneNumber,@RequestParam String code){

      User userinfo=loginService.loginCheck(phoneNumber,code);
      if(userinfo!=null){
        User user = new User();
        user.setUserName(userinfo.getUserName());
        String signToken = TokenUtil.sign(user);//首次登录token签名

        //System.out.println("tolen是"+signToken);
        HashMap<String,String> jsonObject=new HashMap<>();
        jsonObject.put("token",signToken);
        jsonObject.put("msg","登录成功");
        return jsonObject;

      }
      return  null;

    }


  @RequestMapping("/loginWx")
  @ResponseBody
  public HashMap<String,String> loginWx(@RequestParam String phoneNumber){

    User userinfo=loginService.loginCheckWx(phoneNumber);
    if(userinfo!=null){
      User user = new User();
      user.setUserName(userinfo.getUserName());
      String signToken = TokenUtil.sign(user);//首次登录token签名
      //System.out.println("tolen是"+signToken);
      HashMap<String,String> jsonObject=new HashMap<>();
      jsonObject.put("token",signToken);
      jsonObject.put("msg","登录成功");
      return jsonObject;

    }
    return  null;

  }
}

