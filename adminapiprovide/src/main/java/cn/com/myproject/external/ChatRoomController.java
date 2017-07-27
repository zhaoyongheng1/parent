package cn.com.myproject.external;

import cn.com.myproject.live.entity.PO.ChatRoom;
import cn.com.myproject.live.service.IChatRoomService;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrReturnVO;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrVO;
import cn.com.myproject.netease.service.IIMChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/27.
 */
@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private IChatRoomService chatRoomService;

    @Autowired
    private IIMChatroomService imChatroomService;


    @GetMapping("/getList")
    public List<ChatRoom> getList(int pageNum,int pageSize) {
        return chatRoomService.getList(pageNum,pageSize);
    }

    @GetMapping("/requestAddr")
    public IMRequestAddrReturnVO requestAddr(IMRequestAddrVO vo) {
        return imChatroomService.requestAddr(vo);
    }
}
