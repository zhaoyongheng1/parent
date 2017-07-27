package cn.com.myproject.sysuser.entity.PO;


import cn.com.myproject.util.BasePO;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public class SysRoleResource extends BasePO {

    private String roleId;
    private String resourceId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
