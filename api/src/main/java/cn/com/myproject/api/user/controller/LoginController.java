package cn.com.myproject.api.user.controller;

import cn.com.myproject.api.user.entity.Constant;
import cn.com.myproject.api.user.entity.PO.User;
import cn.com.myproject.api.user.service.IUserService;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private IUserService userService;

    @RequestMapping(value="/",method = RequestMethod.POST , produces = "application/json")
    @ApiOperation(value = "用户名密码登录", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "loginName", value = "登录名", required = true, dataType = "String",defaultValue = "honglan1009"),
            @ApiImplicitParam(paramType="query",name = "password", value = "登录密码", required = true, dataType = "String",defaultValue = "honglan1009")
    })
    public Message login(@RequestParam String loginName,@RequestParam  String password, HttpSession httpSession){

        if(StringUtils.isBlank(loginName)){
            return MessageUtils.getFail("登录失败，登录名不能为空");
        }

        if(StringUtils.isBlank(password)){
            return MessageUtils.getFail("登录失败，密码不能为空");
        }
        User user = userService.login(loginName,password);
        if(null != user){
            if(user.getStatus() == 1){
                httpSession.setAttribute(Constant.SESSION_USER,user);
                Message message = MessageUtils.getSuccess("登录成功");
                message.setData(user);
                return message;
            }else{
                //FIXME 状态等待扩展
                return MessageUtils.getFail("登录失败,用户状态不对");
            }
        }
        return MessageUtils.getFail("登录失败,用户不存在");
    }
}
