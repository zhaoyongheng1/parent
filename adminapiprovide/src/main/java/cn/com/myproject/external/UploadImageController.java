package cn.com.myproject.external;

import cn.com.myproject.aliyun.oss.IAliyunOssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

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

    @PostMapping("/uploadImg")
    public String uploadImg(MultipartFile file)  {
        logger.debug("调用者："+discoveryClient.getServices());
        if(null == file || file.isEmpty()) {
            return "";
        }
        String filename = file.getOriginalFilename();
        String url = UploadImageController.getImgPath()+filename.split("\\.")[1];
        try {
            aliyunOssService.upload(url,file.getInputStream());
        } catch (IOException e) {
            logger.error("上传失败",e);
            return "";
        }
        return url;
    }

    private static String getImgPath() {
        LocalDate date = LocalDate.now();
        return "image/"+date.getYear()+"/"+date.getMonth().getValue()+"/"+date.getDayOfMonth()+"/"+ UUID.randomUUID()+".";
    }

}
