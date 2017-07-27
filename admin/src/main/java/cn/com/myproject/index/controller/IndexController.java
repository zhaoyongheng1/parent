package cn.com.myproject.index.controller;

import cn.com.myproject.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Controller
public class IndexController {

    @Autowired
    private ISysUserService userService;


    @RequestMapping({"/index","/"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/demo","/demo1"})
    public String demo(){
        return "demo";
    }

}
