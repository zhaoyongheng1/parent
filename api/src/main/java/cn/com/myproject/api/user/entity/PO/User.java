package cn.com.myproject.api.user.entity.PO;

import cn.com.myproject.api.user.entity.base.BasePO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by liyang-macbook on 2017/6/27.
 */
public class User extends BasePO {
    private String userId;
    @ApiModelProperty("登录名")
    private String loginName;
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String payPassword;

    private String realName;
    private String IDNum;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }
}
