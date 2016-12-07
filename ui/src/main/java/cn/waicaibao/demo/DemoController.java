package cn.waicaibao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.test.BeforeOAuth2Context;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liyang-macbook on 2016/11/17.
 */
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization","Bearer "+restTemplate.getAccessToken());
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        return restTemplate.exchange("http://192.168.2.230:3333/demo/add?a=10&b=20", HttpMethod.GET,entity,String.class).getBody();
        return restTemplate.getForEntity("http://192.168.2.230:3333/demo/add?a=10&b=20",String.class).getBody();

    }
}
