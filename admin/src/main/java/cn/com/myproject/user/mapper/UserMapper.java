package cn.com.myproject.user.mapper;

import cn.com.myproject.user.entity.PO.SysUser;
import cn.com.myproject.user.entity.VO.SysUserVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    SysUser selectById(Long id);
    SysUser selectByLoginName(String loginName);
    List<SysUser> getAll(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);

    List<SysUser> getPage(@Param("pageNumKey") int pageNum, @Param("pageSizeKey") int pageSize);
}
