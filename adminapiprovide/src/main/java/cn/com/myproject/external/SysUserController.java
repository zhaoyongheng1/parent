package cn.com.myproject.external;

import cn.com.myproject.sysuser.entity.VO.SysUserVO;
import cn.com.myproject.sysuser.service.ISysUserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyang-macbook on 2017/7/26.
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService service;

    @GetMapping("/getPage")
    public PageInfo<SysUserVO> getPage(int pageNum, int pageSize) {
        return service.getPage(pageNum,pageSize);
    }

    @GetMapping("/getByLoginName")
    public SysUserVO getByLoginName(String loginName) {
        return service.getByLoginName(loginName);
    }
}
