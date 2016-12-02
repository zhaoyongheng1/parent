package cn.waicaibao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by liyang-macbook on 2016/12/1.
 */
@RestController
public class UserController {
    @RequestMapping("/user")
    public Map<String, String> user(Principal user, HttpServletRequest request) {
        return Collections.singletonMap("name", user.getName());
    }
}
