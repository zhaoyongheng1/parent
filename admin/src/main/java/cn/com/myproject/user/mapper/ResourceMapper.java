package cn.com.myproject.user.mapper;

import cn.com.myproject.user.entity.PO.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Mapper
public interface ResourceMapper {

    List<SysResource> getValueByRoleId(String roleId);

    List<String> getAllValue();

    List<String> getAllUseValue(String type);

    LinkedHashSet<SysResource> getMenu(String userId);

    LinkedHashSet<SysResource> getMenuByResourceId(String userId,String resourceId);
}
