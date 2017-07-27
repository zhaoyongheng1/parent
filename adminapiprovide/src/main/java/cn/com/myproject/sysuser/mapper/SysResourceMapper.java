package cn.com.myproject.sysuser.mapper;


import cn.com.myproject.sysuser.entity.PO.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Mapper
public interface SysResourceMapper {

    List<SysResource> getValueByRoleId(String roleId);

    List<String> getAllValue();

    List<String> getAllUseValue(String type);

    LinkedHashSet<SysResource> getMenu(String userId);

    LinkedHashSet<SysResource> getMenuByResourceId(String userId, String resourceId);
}
