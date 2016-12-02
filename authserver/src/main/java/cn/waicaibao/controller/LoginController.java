package cn.waicaibao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by liyang-macbook on 2016/12/1.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }
    @RequestMapping("/oauth/confirm_access")
    public String auth(){
        return "authorize";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user, org.apache.catalina.servlet4preview.http.HttpServletRequest request) {
        return user;
    }

}
