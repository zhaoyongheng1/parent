package cn.com.myproject.api.live.controller;


import cn.com.myproject.api.service.IChatRoomService;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
import cn.com.myproject.live.entity.PO.ChatRoom;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrReturnVO;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrVO;
import cn.com.myproject.user.entity.Constant;
import cn.com.myproject.user.entity.PO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/1.
 */
@RestController
@RequestMapping("/api/chatroom")
public class ChatroomController {

    @Autowired
    private IChatRoomService chatRoomService;


    @RequestMapping("/homeList")
    public Message homeList(){

        List<ChatRoom> list = chatRoomService.getList(1,12);
        Message message = MessageUtils.getSuccess("获取成功");
        message.setData(list);

        return message;
    }


    @RequestMapping("/requestAddress")
    public Message requestAddress(Long roomid, HttpSession httpSession) {

        User user = (User) httpSession.getAttribute(Constant.SESSION_USER);
        IMRequestAddrVO vo = new IMRequestAddrVO();
        vo.setRoomid(roomid);
        vo.setAccid(user.getAccid());
        IMRequestAddrReturnVO result = chatRoomService.requestAddr(vo);
        if(result.getCode() == 200){
            Message message = MessageUtils.getSuccess("获取成功");
            message.setData(result.getAddr());
            return message;
        }
        return MessageUtils.getFail("获取失败");
    }
}
