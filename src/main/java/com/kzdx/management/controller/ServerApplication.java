package com.kzdx.management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.kzdx.management.service.PostData;
import com.kzdx.management.util.WechatUtils;
import com.kzdx.management.util.globalData;
import org.springframework.boot.SpringApplication;

import org.springframework.web.bind.annotation.*;


@RestController
public class ServerApplication {
    com.kzdx.management.util.globalData globalData = new globalData();
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
    //解析电话号码
    @GetMapping("/getsessionkey")
    public Object getsessionkey(String js_code,String encryptedData, String iv) throws JsonProcessingException {
        PostData PostData = new PostData();
        String responseData =  PostData.PostData(globalData.url, globalData.appid, globalData.secret,js_code,globalData.grant_type);
        //获取SessionKey 和openid
        ObjectMapper mapper = new ObjectMapper();
        JsonNode resData = mapper.readTree(responseData);
        try{
            if(resData.get("session_key").asText()!=null)
            {
                String SessionKey = resData.get("session_key").asText();
                String openid = resData.get("openid").asText();
                System.out.println("SessionKey="+SessionKey);
                System.out.println("openid="+openid);
                System.out.println("encryptedData="+encryptedData);
                System.out.println("iv="+iv);
                String wxDecrypt = WechatUtils.wxDecrypt(encryptedData,SessionKey,iv);
                System.out.println(wxDecrypt);
                return wxDecrypt;
            }else {
                System.out.println("请求微信服务器异常");
            }

        }catch (Exception e)
        {
            System.out.println("请求微信服务器异常");
        }
        return 0;
    }

}
