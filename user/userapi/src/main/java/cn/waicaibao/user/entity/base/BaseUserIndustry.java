package cn.waicaibao.user.entity.base;

import java.util.Date;

/**
 * 用户行业基类
 * Created by Administrator on 2016/7/20.
 */
public abstract class BaseUserIndustry {
    /**
     * 用户行业ID
     */
    private Long id;
    /**
     * 用户行业名称
     */
    private String name;
    /**
     * 用户父类行业ID
     */
    private Long pid;
    /**
     * 用户行业状态: 0无效 , 1有效
     */
    private Integer state;
    /**
     * 用户行业版本
     */
    private Integer version;
    /**
     * 用户行业创建时间
     */
    private Date createTime;
    /**
     * 用户行业更新时间
     */
    private Date updateTime;
    /**
     * 用户行业创建者ID
     */
    private Long createUser;
    /**
     * 备注信息
     */
    private String remark;

    /**
     * 排序
     * @return
     */
    private Long seqno;

    /**
     *更改操作者
     * @return
     */
    private Long updateUser;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }
}
