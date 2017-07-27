package cn.com.myproject.live.mapper;

import cn.com.myproject.live.entity.PO.LiveRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
@Mapper
public interface LiveRoomMapper {
    List<LiveRoom> getList();
    int insert(LiveRoom room);
    int update(LiveRoom room);

}