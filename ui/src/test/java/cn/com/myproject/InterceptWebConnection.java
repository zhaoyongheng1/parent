package cn.com.myproject;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.util.FalsifyingWebConnection;

import java.io.IOException;

/**
 * Created by liyang-macbook on 2017/4/18.
 */
public class InterceptWebConnection extends FalsifyingWebConnection {
    public InterceptWebConnection(WebClient webClient) throws IllegalArgumentException{
        super(webClient);
    }
    @Override
    public WebResponse getResponse(WebRequest request) throws IOException {
        WebResponse response=super.getResponse(request);
        //http://a.cnzz.com http://hb.crm2.qq.com
        if(response.getWebRequest().getUrl().toString().contains("tuiqiu.net") || response.getWebRequest().getUrl().toString().contains("tuiqiu2.net")){
            return super.getResponse(request);

        }else{
            return createWebResponse(response.getWebRequest(), "", "application/javascript", 200, "Ok");
        }

    }
}
