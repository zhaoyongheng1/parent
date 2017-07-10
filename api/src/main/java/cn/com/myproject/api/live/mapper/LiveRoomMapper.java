package cn.com.myproject.api.live.mapper;

import cn.com.myproject.api.live.entity.PO.LiveRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
@Mapper
public interface LiveRoomMapper {
    List<LiveRoom> getList();
}
