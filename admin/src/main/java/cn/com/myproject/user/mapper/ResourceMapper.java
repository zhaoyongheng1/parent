package cn.com.myproject.user.mapper;

import cn.com.myproject.user.entity.PO.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/22.
 */
@Mapper
public interface ResourceMapper {
    List<SysResource> getValueByRoleId(String roleId);

    List<String> getAllValue();

    List<String> getAllUseValue(String type);
}
