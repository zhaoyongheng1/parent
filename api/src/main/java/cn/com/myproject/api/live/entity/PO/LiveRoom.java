package cn.com.myproject.api.live.entity.PO;

import cn.com.myproject.api.user.entity.base.BasePO;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
public class LiveRoom extends BasePO {
    /**
     * 房间ID
     * */
    private String roomId;
    /**
     * 房间名字
     * */
    private String roomName;
    /**
     *网易直播频道ID
     * */
    private String cid;
    /**
     *网易直播频道创建时间戳
     * */
    private Long ctime;
    private String pushurl;
    private String httppullurl;
    private String hlspullurl;
    private String rtmppullurl;
    /**
     *网易直播间名称
     * */
    private String liveName;
    /**
     * 网易直播间类型 ( 0 : rtmp)
     * */
    private Short liveType;


    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public String getPushurl() {
        return pushurl;
    }

    public void setPushurl(String pushurl) {
        this.pushurl = pushurl;
    }

    public String getHttppullurl() {
        return httppullurl;
    }

    public void setHttppullurl(String httppullurl) {
        this.httppullurl = httppullurl;
    }

    public String getHlspullurl() {
        return hlspullurl;
    }

    public void setHlspullurl(String hlspullurl) {
        this.hlspullurl = hlspullurl;
    }

    public String getRtmppullurl() {
        return rtmppullurl;
    }

    public void setRtmppullurl(String rtmppullurl) {
        this.rtmppullurl = rtmppullurl;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public Short getLiveType() {
        return liveType;
    }

    public void setLiveType(Short liveType) {
        this.liveType = liveType;
    }
}
