package cn.com.myproject.api.user.mapper;


import cn.com.myproject.api.user.entity.PO.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectById(Long id);
    User selectByLoginName(String loginName);
}
