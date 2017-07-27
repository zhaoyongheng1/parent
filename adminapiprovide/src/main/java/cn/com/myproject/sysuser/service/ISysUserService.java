package cn.com.myproject.sysuser.service;

import cn.com.myproject.sysuser.entity.PO.SysUser;
import cn.com.myproject.sysuser.entity.VO.SysUserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/21.
 */
public interface ISysUserService {
    SysUserVO getByLoginName(String loginName);

    List<SysUser> getAll();

    PageInfo<SysUserVO> getPage(int pageNum, int pageSize);
}
