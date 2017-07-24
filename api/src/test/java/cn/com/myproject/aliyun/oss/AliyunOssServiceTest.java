package cn.com.myproject.aliyun.oss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by liyang-macbook on 2017/7/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AliyunOssServiceTest {

    @Autowired
    private IAliyunOssService aliyunOssService;

    @Test
    public void testUpload() throws FileNotFoundException {
        InputStream in = new FileInputStream("/Users/liyang-macbook/Downloads/zhuzi.png");
        aliyunOssService.upload("test/2017/07/24/111111.png",in);
    }
}
