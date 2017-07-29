package cn.com.myproject.service;

import cn.com.myproject.config.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by liyang-macbook on 2017/7/27.
 */
@FeignClient(name = "admin-api-provide",configuration = FeignMultipartSupportConfig.class)
public interface IUploadImgService {

    @PostMapping(value = "/uploadImg",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadImg(@RequestPart("file") MultipartFile file);

}
