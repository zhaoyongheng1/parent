package cn.com.myproject.sysuser.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Mapper
public interface SysRoleMapper {
    List<String> getAllRoleName();
    List<String> getAllRoleId();
    List<String> getAllUseRoleId();
    List<String> getRoleIds(String userId);
}
