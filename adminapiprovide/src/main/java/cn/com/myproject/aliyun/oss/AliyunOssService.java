package cn.com.myproject.aliyun.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by liyang-macbook on 2017/7/24.
 */

@Component
public class AliyunOssService implements IAliyunOssService {

    @Autowired
    private AliyunOssProp aliyunOssProp;

    @Override
    public OSSClient create() {
        return new OSSClient(aliyunOssProp.getEndpoint(),aliyunOssProp.getAccessKeyId(),aliyunOssProp.getAccessKeySecret());
    }

    @Override
    public void shutDown(OSSClient client) {
        client.shutdown();
    }

    @Override
    public String upload(String key,InputStream inputStream) {
        OSSClient ossClient = this.create();
        PutObjectResult result = ossClient.putObject(aliyunOssProp.getBucketName(),key,inputStream);
        this.shutDown(ossClient);
        return "http://"+aliyunOssProp.getBucketName()+"."+aliyunOssProp.getEndpoint()+"/"+key;
    }
}
