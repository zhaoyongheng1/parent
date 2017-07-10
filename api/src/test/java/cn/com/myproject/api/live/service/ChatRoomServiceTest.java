package cn.com.myproject.api.live.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatRoomServiceTest {

    @Autowired
    private IChatRoomService chatRoomService;

    @Test
    public void testCreateChatRoom(){
        chatRoomService.createChatRoom("honglan1009","honglan1009","红懒的直播房间","别乱BB,小心爆菊");
    }
}
