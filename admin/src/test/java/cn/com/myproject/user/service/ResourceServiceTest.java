package cn.com.myproject.user.service;

import cn.com.myproject.AdminApplication;
import cn.com.myproject.user.entity.VO.MenuVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * Created by liyang-macbook on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdminApplication.class)
public class ResourceServiceTest {
    @Autowired
    private IResourceService resourceService;

    @Test
    public void testgetMenu() {
        Set<MenuVO> set = this.resourceService.getMenu("7","sdlfjslkdf11");
        System.out.println(set.size());
    }
}
