package cn.com.myproject.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Mapper
public interface RoleMapper {
    List<String> getAllRoleName();
    List<String> getAllRoleId();
    List<String> getAllUseRoleId();
    List<String> getRoleIds(String userId);
}
