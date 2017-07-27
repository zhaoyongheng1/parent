package cn.com.myproject.sysuser.entity.VO;


import cn.com.myproject.sysuser.entity.PO.SysUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */

public class SysUserVO {

    private String userId;
    private String loginName;
    private String userName;
    private String nickName;
    private String password;
    private String phone;
    private Integer id;
    private Long createTime;
    private Short status;
    private Integer version;

    public SysUserVO(){
        super();
    }

    public SysUserVO(SysUser user){
        this.setId(user.getId());
        this.setUserId(user.getUserId());
        this.setLoginName(user.getLoginName());
        this.setNickName(user.getNickName());
        this.setPassword(user.getPassword());
        this.setCreateTime(user.getCreateTime());
        this.setPhone(user.getPhone());
        this.setStatus(user.getStatus());
        this.setUserName(user.getUserName());
        this.setVersion(user.getVersion());
    }

    private List<String> roleIds;


    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public String getStrStatus() {
        return UserStatus.searchId(this.getStatus());
    }

    /**
     * 获取格式化后的时间
     * */
    public String getFCreateTime() {
        if(null != this.createTime){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(createTime));
        }
        return "";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
