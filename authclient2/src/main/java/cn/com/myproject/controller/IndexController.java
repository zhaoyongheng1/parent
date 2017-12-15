package cn.com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {



    @Autowired
    private OAuth2RestTemplate oauth2RestTemplate;

    @RequestMapping("/")
    public String index1() {
        //String str = oauth2RestTemplate.getForObject("http://zuul.dh.com:3335/private/index",String.class);
        return "client-index";
    }

    @RequestMapping("/private/index")
    public String index() {
        return "client-index,private";
    }
}
