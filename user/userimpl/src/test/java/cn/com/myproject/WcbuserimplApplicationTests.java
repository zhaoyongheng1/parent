package cn.com.myproject;

import cn.com.myproject.user.entity.User;
import cn.com.myproject.user.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WcbuserimplApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		User user = userMapper.selectById(1l);
		System.out.println(user.getName());

		PageHelper.startPage(1,10);
		long i = userMapper.select().size();
		long ii = userMapper.select().size();
		System.out.println(i+","+ii);
	}

}
