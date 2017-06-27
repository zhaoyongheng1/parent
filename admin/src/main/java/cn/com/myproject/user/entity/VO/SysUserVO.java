package cn.com.myproject.user.entity.VO;

import cn.com.myproject.user.entity.PO.SysUser;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */

public class SysUserVO extends SysUser {


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
}
