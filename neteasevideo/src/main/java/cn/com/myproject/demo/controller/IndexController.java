package cn.com.myproject.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by liyang-macbook on 2017/6/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/demo")
    public String index(Map<String,Object> model) {
        model.put("index","111111");
        return "demo";
    }

}
