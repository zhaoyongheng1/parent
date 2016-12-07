package cn.waicaibao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public java.util.Map<String, Object> user(Principal user) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", user.getName());
        return map;
    }

}
