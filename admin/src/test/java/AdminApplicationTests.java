import cn.com.myproject.AdminApplication;
import cn.com.myproject.user.entity.PO.SysUser;
import cn.com.myproject.user.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdminApplication.class)
public class AdminApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
		List<SysUser> list = userMapper.getAll(1,20);
		Assert.assertEquals(1,list.size());
	}

}
