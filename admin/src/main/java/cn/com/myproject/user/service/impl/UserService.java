package cn.com.myproject.user.service.impl;

import cn.com.myproject.user.entity.PO.SysUser;
import cn.com.myproject.user.entity.VO.SysUserVO;
import cn.com.myproject.user.mapper.RoleMapper;
import cn.com.myproject.user.mapper.UserMapper;
import cn.com.myproject.user.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public PageInfo<SysUserVO> getPage(int pageNum, int pageSize) {
        List<SysUser> list = this.userMapper.getPage(pageNum,pageSize);
        return convert(list);
    }

    private PageInfo<SysUserVO> convert(List<SysUser> list) {
        PageInfo<SysUser> info = new PageInfo(list);

        List<SysUser> _list = info.getList();
        info.setList(null);
        List<SysUserVO> __list = new ArrayList<>(10);

        PageInfo<SysUserVO> _info = new PageInfo();
        BeanUtils.copyProperties(info,_info);
        if(null !=_list && _list.size() != 0) {
            for(SysUser user : _list) {
                __list.add(new SysUserVO(user));
            }
            _info.setList(__list);
        }

        return _info;
    }
}
