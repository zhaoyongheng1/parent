package cn.com.myproject.sysuser.mapper;


import cn.com.myproject.sysuser.entity.PO.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper {
    SysUser selectById(Long id);
    SysUser selectByLoginName(String loginName);
    List<SysUser> getAll(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);

    List<SysUser> getPage(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);
}
