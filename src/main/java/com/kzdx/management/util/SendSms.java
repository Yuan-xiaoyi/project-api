package com.kzdx.management.util;

import java.util.Map;

public interface SendSms {
    public boolean send(String phoneNum, String templateCode, Map<String,Object> code) throws Exception;
    public boolean send(String phoneNum, String templateCode) throws Exception;
}
