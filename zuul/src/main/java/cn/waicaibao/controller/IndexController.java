package cn.waicaibao.controller;

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
    @RequestMapping("/index")
    public String index1(HttpServletRequest request){
        return "index1";
    }
}
