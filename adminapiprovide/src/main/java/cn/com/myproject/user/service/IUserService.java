package cn.com.myproject.user.service;


import cn.com.myproject.user.entity.PO.User;

/**
 * Created by liyang-macbook on 2017/6/30.
 */
public interface IUserService {
    void reigister(User user);
    User getByLogin(String loginName);
    User login(String loginName, String pwd);
}
