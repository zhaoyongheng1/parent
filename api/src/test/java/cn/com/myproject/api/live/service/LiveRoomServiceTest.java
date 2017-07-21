package cn.com.myproject.api.live.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liyang-macbook on 2017/7/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LiveRoomServiceTest {

    @Autowired
    private ILiveRoomService liveRoomService;

    @Test
    public void testCreate() {
        liveRoomService.create("红懒的直播间","4b2970e94be24e50bcfc396132ab1a1d");
    }
}
