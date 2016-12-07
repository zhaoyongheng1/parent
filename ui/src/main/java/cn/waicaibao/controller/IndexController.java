package cn.waicaibao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liyang-macbook on 2016/12/5.
 */
@Controller
public class IndexController {


    @RequestMapping({"/","/index"})
    @ResponseBody
    public String index(){
        return "index";
    }
}
