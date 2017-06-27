package cn.com.myproject.api.user.entity.base;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public class BasePO implements Serializable{
    @ApiModelProperty("主键ID")
    private Integer id;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("状态")
    private Short status;
    @ApiModelProperty("版本号")
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
