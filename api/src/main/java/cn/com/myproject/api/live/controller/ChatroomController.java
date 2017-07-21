package cn.com.myproject.api.live.controller;

import cn.com.myproject.api.im.VO.ResultChatroom;
import cn.com.myproject.api.im.VO.chatroom.IMGetVO;
import cn.com.myproject.api.im.VO.chatroom.IMRequestAddrReturnVO;
import cn.com.myproject.api.im.VO.chatroom.IMRequestAddrVO;
import cn.com.myproject.api.im.service.IIMChatroomService;
import cn.com.myproject.api.live.entity.PO.ChatRoom;
import cn.com.myproject.api.live.service.IChatRoomService;
import cn.com.myproject.api.user.entity.Constant;
import cn.com.myproject.api.user.entity.PO.User;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
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

    @Autowired
    private IIMChatroomService imChatroomService;

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
        IMRequestAddrReturnVO result = imChatroomService.requestAddr(vo);
        if(result.getCode() == 200){
            Message message = MessageUtils.getSuccess("获取成功");
            message.setData(result.getAddr());
            return message;
        }
        return MessageUtils.getFail("获取失败");
    }
}
