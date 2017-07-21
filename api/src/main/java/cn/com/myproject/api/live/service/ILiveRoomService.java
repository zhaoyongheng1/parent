package cn.com.myproject.api.live.service;

import cn.com.myproject.api.live.entity.PO.LiveRoom;

/**
 * Created by liyang-macbook on 2017/7/19.
 */
public interface ILiveRoomService {
    void create(String roomName,String userId);
}
