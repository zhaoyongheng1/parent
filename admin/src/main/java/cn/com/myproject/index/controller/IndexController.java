package cn.com.myproject.index.controller;

import cn.com.myproject.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;


    @RequestMapping({"/index","/"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/demo","/demo1"})
    public String demo(){
        userService.getAll();
        return "demo";
    }

}
