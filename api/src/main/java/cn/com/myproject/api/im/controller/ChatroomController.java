package cn.com.myproject.api.im.controller;

import cn.com.myproject.api.im.VO.ResultChatroom;
import cn.com.myproject.api.im.VO.ResultData;
import cn.com.myproject.api.im.VO.chatroom.IMGetVO;
import cn.com.myproject.api.im.VO.chatroom.IMRequestAddrReturnVO;
import cn.com.myproject.api.im.VO.chatroom.IMRequestAddrVO;
import cn.com.myproject.api.im.VO.chatroom.IMTopnVO;
import cn.com.myproject.api.im.service.IIMChatroomService;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private IIMChatroomService imChatroomService;

    @RequestMapping("/homeList")
    public Message homeList(){
        //FIXME 为了测试
        IMGetVO vo = new IMGetVO();
        vo.setRoomid(9691187l);
        ResultChatroom room = imChatroomService.get(vo);
        if(room.getCode() == 200){
            Message message = MessageUtils.getSuccess("获取成功");
            List<LinkedHashMap<String,String>> list = new ArrayList<>();
            list.add(room.getChatroom());
            message.setData(list);
            return message;
        }
        return MessageUtils.getFail("获取失败");
    }


    @RequestMapping("/requestAddress")
    public Message requestAddress(Long roomid,String uid) {
        IMRequestAddrVO vo = new IMRequestAddrVO();
        vo.setRoomid(roomid);
        vo.setAccid(uid);
        IMRequestAddrReturnVO result = imChatroomService.requestAddr(vo);
        if(result.getCode() == 200){
            Message message = MessageUtils.getSuccess("获取成功");
            message.setData(result.getAddr());
            return message;
        }
        return MessageUtils.getFail("获取失败");
    }
}
