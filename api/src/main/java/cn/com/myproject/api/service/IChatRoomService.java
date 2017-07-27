package cn.com.myproject.api.service;

import cn.com.myproject.live.entity.PO.ChatRoom;
import cn.com.myproject.netease.VO.ResultChatroomDesc;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrReturnVO;
import cn.com.myproject.netease.VO.chatroom.IMRequestAddrVO;
import cn.com.myproject.netease.VO.chatroom.IMSendMsgVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/27.
 */
@FeignClient("admin-api-provide")
public interface IChatRoomService {

    @GetMapping("/chatroom/getList")
    List<ChatRoom> getList(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize") int pageSize);

    /**
     *请求聊天室地址
     * */
    @GetMapping("/chatroom/requestAddr")
    IMRequestAddrReturnVO requestAddr(IMRequestAddrVO vo);

}
