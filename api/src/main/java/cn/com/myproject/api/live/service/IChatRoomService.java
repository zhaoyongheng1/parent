package cn.com.myproject.api.live.service;

import cn.com.myproject.api.live.entity.PO.ChatRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
public interface IChatRoomService {
    void createChatRoom(String userId,String accid,String roomName,String roomRemark);
    List<ChatRoom> getList(int pageNum,  int pageSize);
}
