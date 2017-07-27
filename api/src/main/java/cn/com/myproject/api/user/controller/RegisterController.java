package cn.com.myproject.api.user.controller;


import cn.com.myproject.api.service.IUserService;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
import cn.com.myproject.user.entity.Constant;
import cn.com.myproject.user.entity.PO.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by liyang-macbook on 2017/6/30.
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/", method = RequestMethod.POST , produces = "application/json")
    public Message register(String username, String password, String nickname,HttpSession httpSession){

        if(StringUtils.isBlank(username)){
            return MessageUtils.getSuccess("注册失败，用户名不能为空");
        }

        if(StringUtils.isBlank(password)){
            return MessageUtils.getSuccess("注册失败，密码不能为空");
        }

        if(StringUtils.isBlank(nickname)){
            return MessageUtils.getSuccess("注册失败，昵称不能为空");
        }

        User user = new User();
        user.setUserName(username);
        user.setLoginName(username);
        user.setPassword(password);
        user.setNickName(nickname);
        try {
            userService.reigister(user);
        }catch (RuntimeException e) {
            logger.error("注册失败",e);
            return MessageUtils.getSuccess("注册失败");
        }
        httpSession.setAttribute(Constant.SESSION_USER,userService.getByLogin(user.getLoginName()));
        return MessageUtils.getSuccess("注册成功");
    }
}
