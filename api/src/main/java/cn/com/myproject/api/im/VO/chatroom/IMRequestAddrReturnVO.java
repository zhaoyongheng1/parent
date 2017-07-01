package cn.com.myproject.api.im.VO.chatroom;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/29.
 */
public class IMRequestAddrReturnVO implements Serializable {

    private Integer code;
    private List<String> addr;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }
}
