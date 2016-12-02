package cn.waicaibao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyang-macbook on 2016/12/1.
 */
@RestController
public class IndexController {


    @RequestMapping("/")
    public String index(HttpServletRequest request){
        return "index";
    }
}
