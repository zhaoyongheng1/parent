package cn.com.myproject.api.user.service;

import cn.com.myproject.api.user.entity.PO.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liyang-macbook on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserserviceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testReigister(){
        User user = new User();
        user.setUserName("honglan1009");
        user.setNickName("红懒");
        user.setLoginName("honglan1009");
        user.setPassword("honglan1009");
        userService.reigister(user);
    }
}
