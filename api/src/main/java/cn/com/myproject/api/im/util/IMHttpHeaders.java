package cn.com.myproject.api.im.util;

import cn.com.myproject.api.im.common.CheckSumBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Date;

/**
 * Created by liyang-macbook on 2017/6/29.
 */
public class IMHttpHeaders {
    private static final String APPKEY = "45dded212ccce76835488e5ca320c063";

    private static final String APPSECRET = "311cc53a114d";

    public static HttpHeaders get(){

        String nonce =  "myproject";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APPSECRET, nonce ,curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.parseMediaType("application/x-www-form-urlencoded;charset=utf-8"));
        headers.set("AppKey", APPKEY);
        headers.set("Nonce", nonce);
        headers.set("CurTime", curTime);
        headers.set("CheckSum", checkSum);

        return headers;
    }

    public static HttpHeaders getJSON(){
        String nonce =  "myproject.com";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APPSECRET, nonce ,curTime);//参考 计算CheckSum的java代码

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.parseMediaType("application/json;charset=utf-8"));
        headers.set("AppKey", APPKEY);
        headers.set("Nonce", nonce);
        headers.set("CurTime", curTime);
        headers.set("CheckSum", checkSum);

        return headers;
    }
}
