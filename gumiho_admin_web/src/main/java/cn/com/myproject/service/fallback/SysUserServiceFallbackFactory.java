package cn.com.myproject.service.fallback;

import cn.com.myproject.adminuser.vo.SysUserVO;
import cn.com.myproject.service.ISysUserService;
import com.github.pagehelper.PageInfo;
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
        return new ISysUserService() {
            @Override
            public SysUserVO getByLoginName(String loginName) {
                return null;
            }

            @Override
            public SysUserVO getByUserName(String userName) {
                return null;
            }

            @Override
            public PageInfo<SysUserVO> getPage(int pageNum, int pageSize, String keyword) {
                return null;
            }

            @Override
            public void addUsers(SysUserVO sysUserVO) {

            }

            @Override
            public void updateUsers(SysUserVO sysUserVO) {

            }

            @Override
            public void delUsers(Integer id) {

            }

            @Override
            public SysUserVO findByUserId(String userId) {
                return null;
            }

            @Override
            public Integer checkUsers(String userName) {
                return null;
            }

            @Override
            public SysUserVO selectUsers(Integer id) {
                return null;
            }

            @Override
            public SysUserVO getSysUserByLoginName(String loginName) {
                return null;
            }

            @Override
            public SysUserVO getSysUserByUserName(String userName) {
                return null;
            }
        };
    }
}