package cn.waicaibao.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyang-macbook on 2016/11/27.
 */
@RestController
public class DemoController {
    @RequestMapping("/demo1")
    @PreAuthorize("hasPermission('PER','demo1')")
    public String demo1(){
        return "demo1";
    }
}
