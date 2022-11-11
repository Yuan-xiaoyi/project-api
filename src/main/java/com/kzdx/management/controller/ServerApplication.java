package com.kzdx.management.controller;

import cn.hutool.http.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.kzdx.management.service.PostData;
import com.kzdx.management.util.HttpRestUtils;
import com.kzdx.management.util.WechatUtils;
import com.kzdx.management.util.globalData;
import org.springframework.boot.SpringApplication;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class ServerApplication {
    com.kzdx.management.util.globalData globalData = new globalData();

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    //解析电话号码
    @GetMapping("/getsessionkey")
    public Object getsessionkey(String js_code, String encryptedData, String iv) throws JsonProcessingException {
//        PostData PostData = new PostData();
//        String responseData =  PostData.PostData(globalData.url, globalData.appid, globalData.secret,js_code,globalData.grant_type);
//        //获取SessionKey 和openid
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode resData = mapper.readTree(responseData);
        try {
            String replaceUrl = globalData.refrenTokenUrl
                    .replace("{2}", globalData.grant_type)
                    .replace("{0}", globalData.appid)
                    .replace("{1}", globalData.secret);
            String res = HttpUtil.get(replaceUrl);
            JSONObject json_token = JSON.parseObject(res);
            String access_token = json_token.getString("access_token");

            String replaceUrlTwo = globalData.getPhoneNumberUrl.replace("{0}",access_token);
            HashMap<String, Object> requestParam = new HashMap<>();
            // 手机号调用凭证
            requestParam.put("code", js_code);
            String jsonStr = JSON.toJSONString(requestParam);
            HttpResponse response = HttpRequest.post(replaceUrlTwo)
                    .header(Header.CONTENT_ENCODING, "UTF-8")
                    // 发送json数据需要设置contentType
                    .header(Header.CONTENT_TYPE, "application/x-www-form-urlencoded")
                    .body(jsonStr)
                    .execute();
            if (response.getStatus() == HttpStatus.HTTP_OK) {
                return response.body();
            }
//            if(resData.get("session_key").asText()!=null)
//            {
//                String SessionKey = resData.get("session_key").asText();
//                String openid = resData.get("openid").asText();
//                System.out.println("SessionKey="+SessionKey);
//                System.out.println("openid="+openid);
//                System.out.println("encryptedData="+encryptedData);
//                System.out.println("iv="+iv);
//                String wxDecrypt = WechatUtils.wxDecrypt(encryptedData,SessionKey,iv);
//                System.out.println(wxDecrypt);
//                return wxDecrypt;
//            }else {
//                System.out.println("请求微信服务器异常");
//            }

        } catch (Exception e) {
            System.out.println("请求微信服务器异常");
        }
        return 0;
    }

    //解析电话号码
    @GetMapping("/getsessionkey2")
    public Object getsessionkey2(String code) throws JsonProcessingException {
        PostData PostData = new PostData();
        String responseData =  PostData.PostData(globalData.url, globalData.appid, globalData.secret,code,globalData.grant_type);
        //获取SessionKey 和openid
        ObjectMapper mapper = new ObjectMapper();
        JsonNode resData = mapper.readTree(responseData);
        try {
            if(resData.get("openid").asText()!=null){
                String openid = resData.get("openid").asText();
                return openid;
            }else {
                System.out.println("请求微信服务器异常");
            }

        } catch (Exception e) {
            System.out.println("请求微信服务器异常");
        }
        return 0;
    }
}
