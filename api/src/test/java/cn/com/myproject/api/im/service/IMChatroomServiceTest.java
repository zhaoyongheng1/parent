package cn.com.myproject.api.im.service;

import cn.com.myproject.api.im.VO.ResultChatroom;
import cn.com.myproject.api.im.VO.ResultData;
import cn.com.myproject.api.im.VO.chatroom.*;
import cn.com.myproject.api.im.service.impl.IMChatroomService;
import cn.com.myproject.api.live.entity.PO.Robot;
import cn.com.myproject.api.live.service.IRobotService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IMChatroomServiceTest {

    @Autowired
    private IIMChatroomService imChatroomService;

    @Autowired
    private IRobotService robotService;

    @Test
    public void testCreate() {
        IMCreateVO vo = new IMCreateVO();
        vo.setCreator("honglan1009");//honglan1009
        vo.setName("myproject聊天室测试");
        vo.setAnnouncement("别乱BB,小心爆菊");
        ResultChatroom result = imChatroomService.create(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void testTopn() {
        IMTopnVO vo = new IMTopnVO();
        ResultData result = this.imChatroomService.topn(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }
    @Test
    public void testrequestAddr() {
        IMRequestAddrVO vo = new IMRequestAddrVO();
        vo.setRoomid(9758764l);
        vo.setAccid("honglan1009");
        IMRequestAddrReturnVO result = imChatroomService.requestAddr(vo);
        Assert.assertEquals("状态码",result.getCode()+"","200");
    }

    @Test
    public void testaddRobot() {
        IMAddRobotVO vo = new IMAddRobotVO();
        vo.setRoomid(10035164l);
        List<String> list = new ArrayList<>();
        PageInfo<Robot> info =  robotService.getPage(1,100);
        if(null != info && null != info.getList()) {
            for(Robot robot:info.getList()) {
                list.add(robot.getAccid());
            }
        }

        vo.setAccids(JSON.toJSONString(list));
        imChatroomService.addRobot(vo);
    }

    @Test
    public void testRemoveRobot() {
        IMAddRobotVO vo = new IMAddRobotVO();
        vo.setRoomid(10035164l);
        List<String> list = new ArrayList<>();
        PageInfo<Robot> info =  robotService.getPage(1,100);
        if(null != info && null != info.getList()) {
            for(Robot robot:info.getList()) {
                list.add(robot.getAccid());
            }
        }

        vo.setAccids(JSON.toJSONString(list));
        imChatroomService.removeRobot(vo);
    }


 }
