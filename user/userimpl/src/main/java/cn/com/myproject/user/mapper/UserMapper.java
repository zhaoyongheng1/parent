package cn.com.myproject.user.mapper;


import cn.com.myproject.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyang-macbook on 2016/11/21.
 */
@Mapper
public interface UserMapper {
    User selectById(Long id);
    List<User> select();
}
