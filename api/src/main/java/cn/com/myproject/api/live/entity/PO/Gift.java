package cn.com.myproject.api.live.entity.PO;

import cn.com.myproject.api.user.entity.base.BasePO;

/**
 * Created by liyang-macbook on 2017/7/5.
 */
public class Gift extends BasePO {
    /**
     *礼物ID
     * */
    private String giftId;
    /**
     *礼物名称
     * */
    private String giftName;
    /**
     *价值
     * */
    private Integer virtualMoney;
    /**
     *排序 倒序
     * */
    private Integer seqno;
    /**
     *图片
     * */
    private String imgUrl;
    /**
     *大图片
     * */
    private String bigImgUrl;
    /**
     *发送数量设置
     * */
    private String enclises;


    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public Integer getVirtualMoney() {
        return virtualMoney;
    }

    public void setVirtualMoney(Integer virtualMoney) {
        this.virtualMoney = virtualMoney;
    }

    public Integer getSeqno() {
        return seqno;
    }

    public void setSeqno(Integer seqno) {
        this.seqno = seqno;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public String getEnclises() {
        return enclises;
    }

    public void setEnclises(String enclises) {
        this.enclises = enclises;
    }
}
