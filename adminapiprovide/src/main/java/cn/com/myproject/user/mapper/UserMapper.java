package cn.com.myproject.user.mapper;


import cn.com.myproject.user.entity.PO.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectById(Long id);
    User selectByLoginName(String loginName);
    int insert(User user);
    int updateAccId(@Param("loginName") String loginName, @Param("accid") String accid, @Param("accidToken") String accidToken);
}
