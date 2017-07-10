package cn.com.myproject.api.live.controller;

import cn.com.myproject.api.im.VO.ResultChatroomDesc;
import cn.com.myproject.api.im.VO.chatroom.IMSendMsgVO;
import cn.com.myproject.api.im.service.IIMChatroomService;
import cn.com.myproject.api.live.service.IChatRoomService;
import cn.com.myproject.api.user.entity.Constant;
import cn.com.myproject.api.user.entity.PO.User;
import cn.com.myproject.api.util.Message;
import cn.com.myproject.api.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by liyang-macbook on 2017/7/6.
 */
@RestController
@RequestMapping("/api/gift")
public class GiftController  {

    @Autowired
    private IIMChatroomService imChatroomService;

    /**
     * 发送礼物
     * @param type 礼物类型
     * @param num 礼物数量
     * @param roomId 聊天室ID
     * */
    @RequestMapping("/")
    public Message send(Integer type,Integer num,Long roomId, HttpSession httpSession) {
        //FIXME 逻辑处理、扣钱、记录、日志


        User user = (User) httpSession.getAttribute(Constant.SESSION_USER);
        //发送自定义消息
        IMSendMsgVO vo = new IMSendMsgVO();
        vo.setRoomid(roomId);
        vo.setMsgId(UUID.randomUUID().toString().replace("-",""));
        vo.setMsgType(100);
        vo.setFromAccid(user.getAccid());
        vo.setAttach("{\"type\":2,\"data\":{\"value\":100}}");
        ResultChatroomDesc result = imChatroomService.sendMsg(vo);
        Message message = MessageUtils.getSuccess("获取成功");
        return message;
    }
}
