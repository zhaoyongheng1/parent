package cn.com.myproject.service.fallback;

import cn.com.myproject.service.ISysUserService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by liyang-macbook on 2017/8/8.
 */
@Component
public class SysUserServiceFallbackFactory implements FallbackFactory<ISysUserService> {
    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceFallbackFactory.class);


    @Override
    public ISysUserService create(Throwable cause) {
        logger.info(cause.getMessage());
        return null;
    }
}