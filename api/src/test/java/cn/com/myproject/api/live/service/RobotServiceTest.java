package cn.com.myproject.api.live.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liyang-macbook on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotServiceTest {

    @Autowired
    private IRobotService robotService;

    @Test
    public void testCreate() {
        for(int i=0;i<1000;i++) {
            this.robotService.create();
        }
    }
}
