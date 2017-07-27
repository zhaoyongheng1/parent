package cn.com.myproject.api.service;

import cn.com.myproject.user.entity.PO.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liyang-macbook on 2017/7/27.
 */
@FeignClient("admin-api-provide")
public interface IUserService {

    @GetMapping("/user/reigister")
    void reigister(User user);
    @GetMapping("/user/getByLogin")
    User getByLogin(String loginName);
    @GetMapping("/user/login")
    User login(@RequestParam("loginName") String loginName,@RequestParam("pwd")  String pwd);
}
