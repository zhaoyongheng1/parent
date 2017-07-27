package cn.com.myproject.external;

import cn.com.myproject.user.entity.PO.User;
import cn.com.myproject.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyang-macbook on 2017/7/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/reigister")
    public void reigister(User user) {
        userService.reigister(user);
    }

    @GetMapping("/getByLogin")
    public User getByLogin(String loginName) {
        return userService.getByLogin(loginName);
    }

    @GetMapping("/login")
    public User login(String loginName,String pwd) {
        return userService.login(loginName,pwd);
    }
}
