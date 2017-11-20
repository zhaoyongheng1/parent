package cn.com.myproject.user.entity.base;

import java.util.Date;

/**
 * 用户爱好基类
 * Created by Administrator on 2016/7/20.
 */
public abstract class BaseUserHobby {
    /**
     * 用户爱好id
     */
    private Long id;
    /**
     * 用户爱好名称
     */
    private String name;

    /**
     * 用户爱好版本
     */
    private Integer version;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人ID
     */
    private Long createUser;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态： 0无效 ，1有效
     */
    private Integer state;

    /**
     * 排序
     * @return
     */
    private Long seqno;

    /**
     * 更新者
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}
