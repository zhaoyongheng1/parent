package cn.com.myproject.api.live.service.impl;

import cn.com.myproject.api.im.VO.channel.IMCreateVO;
import cn.com.myproject.api.im.VO.channel.ResultChannel;
import cn.com.myproject.api.im.service.IIMChannelService;
import cn.com.myproject.api.live.entity.PO.LiveRoom;
import cn.com.myproject.api.live.mapper.LiveRoomMapper;
import cn.com.myproject.api.live.service.ILiveRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by liyang-macbook on 2017/7/19.
 */
@Service
public class LiveRoomService implements ILiveRoomService {

    @Autowired
    private IIMChannelService imChannelService;

    @Autowired
    private LiveRoomMapper liveRoomMapper;

    @Transactional
    @Override
    public void create(String roomName,String userId) {
        //1、插入数据
        LiveRoom liveRoom = new LiveRoom();
        liveRoom.setRoomId(UUID.randomUUID().toString().replace("-",""));
        liveRoom.setRoomName(roomName);
        liveRoom.setCtime(Calendar.getInstance().getTimeInMillis());
        liveRoom.setStatus((short)1);
        liveRoom.setVersion(1);
        liveRoom.setUserId(userId);
        int num = liveRoomMapper.insert(liveRoom);
        if(num != 1) {
            throw new RuntimeException("插入数据失败,"+userId);
        }
        //2、调用网易接口，创建直播频道
        IMCreateVO vo = new IMCreateVO();
        vo.setName(liveRoom.getRoomName());
        ResultChannel resultChannel = imChannelService.create(vo);
        if(resultChannel.getCode() != 200) {
            throw new RuntimeException("调用网易创建直播频道接口失败,"+resultChannel.getCode()+","+resultChannel.getMsg());
        }
        //3、更新数据
        liveRoom = new LiveRoom();
        liveRoom.setUserId(userId);
        liveRoom.setCid(resultChannel.getRet().get("cid"));
        liveRoom.setCtime(Long.valueOf(resultChannel.getRet().get("ctime")));
        liveRoom.setHlspullurl(resultChannel.getRet().get("hlsPullUrl"));
        liveRoom.setHttppullurl(resultChannel.getRet().get("httpPullUrl"));
        liveRoom.setPushurl(resultChannel.getRet().get("pushUrl"));
        liveRoom.setRtmppullurl(resultChannel.getRet().get("rtmpPullUrl"));
        liveRoom.setLiveName(resultChannel.getRet().get("name"));
        liveRoom.setLiveType((short)1);
        num = liveRoomMapper.update(liveRoom);
        if(num != 1) {
            throw new RuntimeException("更新数据失败,"+userId);
        }

    }
}
