package cn.com.myproject.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liyang-macbook on 2016/11/21.
 */
@Component
public class UserDao {
    @Autowired
    private SqlSession sqlSession;
}
