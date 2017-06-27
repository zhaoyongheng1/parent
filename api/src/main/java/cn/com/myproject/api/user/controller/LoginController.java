package cn.com.myproject.api.user.controller;

import cn.com.myproject.api.user.entity.PO.User;
import cn.com.myproject.api.util.Message;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by liyang-macbook on 2017/6/27.
 */
@RestController
@RequestMapping("/login")
@Api(value="登录类",tags = "登录")
public class LoginController {

    @RequestMapping(value="/",method = RequestMethod.POST , produces = "application/json")
    @ApiOperation(value = "用户名密码登录", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "loginName", value = "登录名", required = true, dataType = "String",defaultValue = "honglan1009"),
            @ApiImplicitParam(paramType="query",name = "password", value = "登录密码", required = true, dataType = "String",defaultValue = "honglan1009")
    })
    public Message<User> login(@RequestParam String loginName,@RequestParam  String password, HttpSession httpSession){
        httpSession.setAttribute("user","sssssss");
        Message<User> message = new  Message();
        User user = new User();
        user.setVersion(1);
        message.setResult(1);
        message.setData(user);
        return message;
    }
}
