package cn.com.myproject.api.live.mapper;

import cn.com.myproject.api.live.entity.PO.ChatRoom;
import cn.com.myproject.api.live.entity.PO.LiveRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
@Mapper
public interface ChatRoomMapper {
    /**
     * 新增聊天室
     * */
    int insert(ChatRoom room);

    /**
     * 更新IM相关信息
     * */
    int updateIMValue(ChatRoom room);


    /**
     *获取聊天室
     * */
    List<ChatRoom> getList(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);
}
