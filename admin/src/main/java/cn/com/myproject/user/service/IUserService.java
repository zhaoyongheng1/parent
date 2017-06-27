package cn.com.myproject.user.service;

import cn.com.myproject.user.entity.PO.SysUser;
import cn.com.myproject.user.entity.VO.SysUserVO;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public interface IUserService {
    SysUserVO getByLoginName(String loginName);

    List<SysUser> getAll();
}