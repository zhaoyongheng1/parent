package cn.com.myproject.user.service.impl;

import cn.com.myproject.user.entity.PO.SysUser;
import cn.com.myproject.user.entity.VO.SysUserVO;
import cn.com.myproject.user.mapper.RoleMapper;
import cn.com.myproject.user.mapper.UserMapper;
import cn.com.myproject.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public SysUserVO getByLoginName(String loginName) {
        SysUser user =  userMapper.selectByLoginName(loginName);
        SysUserVO vo = new SysUserVO(user);
        vo.setRoleIds(roleMapper.getRoleIds(user.getUserId()));
        return vo;
    }

    @Override
    @PreAuthorize("hasPermission('1','1','3')")
    public List<SysUser> getAll() {
        return null;
    }
}
