package cn.com.myproject.aliyun.external;

import cn.com.myproject.aliyun.oss.IAliyunOssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by liyang-macbook on 2017/7/26.
 */
@RestController
public class UploadImageController {

    private static final Logger logger = LoggerFactory.getLogger(UploadImageController.class);

    @Autowired
    private IAliyunOssService aliyunOssService;


    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/uploadImg")
    public String upload() throws FileNotFoundException {
        logger.debug("调用者："+discoveryClient.getServices());
        String url = "test/2017/07/24/111111.png";
        InputStream in = new FileInputStream("/Users/liyang-macbook/Downloads/zhuzi.png");
        aliyunOssService.upload(url,in);
        return url;
    }

}
