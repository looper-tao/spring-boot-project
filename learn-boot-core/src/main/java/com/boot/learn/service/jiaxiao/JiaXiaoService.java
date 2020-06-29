package com.boot.learn.service.jiaxiao;

import com.boot.learn.untils.KJsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author: yeguxin
 * @date: 2020/6/28
 * @description:
 */
@Slf4j
@Service
public class JiaXiaoService {
    private final static String URL = "http://yyjnshjx.ay001.net/";
    
    
    /**
     * 登陆接口
     */
    public void login(String userName,String passWord) {
        String url = URL + "Server/AccountServer.asmx/MobileLogin?_=" + System.currentTimeMillis();
        Map<String, Object> requestMap = new HashMap();
        requestMap.put("UserName", userName);
        requestMap.put("Password", passWord);
        requestMap.put("LoginType", 0);
        log.info("开始调用驾校登陆接口.");
    
//        String sessionCode = UUID.randomUUID().toString().replaceAll("-","").substring(0,24);
        postRequest(url, KJsonUtils.toJson(requestMap));
    }
    public void getUserInfo(String sessionCode) {
        String url = URL + "Server/BaseInfoServer.asmx/GetUserInfo?_=" + System.currentTimeMillis();
        log.info("开始调用驾校学院信息接口.");
        postRequest(url, null);
    }
    
    private void postRequest(String url, String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentLength(100000);
        headers.set("Cookie", "ASP.NET_SessionId=aqwszxswedcreregeg23fe3s; path=/; HttpOnly");
        RestTemplate restTemplate = new RestTemplate();
        log.info("调用驾校接口,链接-{},调用参数{}", url, requestBody);
        log.info("header "+headers);
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, request, Map.class);
    
        List<String> list = responseEntity.getHeaders().get("Set-Cookie");
        Map response = responseEntity.getBody();
    
        log.info("header "+headers);
        log.info("调用驾校接口,链接-{},调用参数{},调用结果{}", url, requestBody, KJsonUtils.toJson(response));
    }
    
    public static void main(String[] args) {
        String sessionCode = UUID.randomUUID().toString().replaceAll("-","").substring(0,24);
        System.out.println(sessionCode);
    }
}
