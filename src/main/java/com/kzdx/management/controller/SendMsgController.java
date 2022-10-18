package com.kzdx.management.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.credentials.utils.StringUtils;
import com.kzdx.management.entity.User;
import com.kzdx.management.mapper.UserMapper;
import com.kzdx.management.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
@CrossOrigin    //跨域支持
public class SendMsgController {


    @Autowired
    private SendSms sendSms;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @ResponseBody
    @GetMapping("/SendSms")
    public String code(@RequestParam String telephone) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userMapper.findUserByPhoneNumber(telephone);
        if (user != null) {
            //从Redis中获取手机号对应验证码
            String code = redisTemplate.opsForValue().get(telephone);
            //如果获取的验证码不为空，说明已经存在，至于这里我为什么使用Map后面会解释。
            if (!StringUtils.isEmpty(code)) {
                map.put("message", "验证码已存在,还没有过期");
                //用Fastjson转为json返回
                return JSON.toJSONString(map);
            }
            //到了这里说明手机号获得的验证码为空，生成验证码并存储到Redis中
            HashMap<String, Object> param = new HashMap<>();
            code = String.valueOf((int) (Math.random() * 999999) + 100);
            param.put("code", code);
            //调用发送验证码方法，将发送的手机号，短信模板，以及验证码传入
            boolean isSend = sendSms.send(telephone, "SMS_154950909", param);
            //如果发送成功，则将手机号和验证码存入Redis,设置为2分钟后过期
            if (isSend) {
                redisTemplate.opsForValue().set(telephone, code, 30, TimeUnit.MINUTES);

                map.put("message", "验证码发送成功！两分钟内有效");
                return JSON.toJSONString(map);
            } else {
                map.put("message", "验证码发送失败！未知错误！请联系管理员！");
                map.put("code", 500);
                return JSON.toJSONString(map);
            }
        }
        map.put("message", "号码不存在请联系管理员！");
        map.put("code", 500);
        return JSON.toJSONString(map);
    }

}
