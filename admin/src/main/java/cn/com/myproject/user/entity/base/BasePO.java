package cn.com.myproject.user.entity.base;

import java.io.Serializable;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public class BasePO implements Serializable{
    private Integer id;
    private Long createTime;
    private Short status;
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
