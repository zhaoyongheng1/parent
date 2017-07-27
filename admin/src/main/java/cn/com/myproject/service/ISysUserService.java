package cn.com.myproject.service;


import cn.com.myproject.sysuser.entity.VO.SysUserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by liyang-macbook on 2017/7/26.
 */
@FeignClient("admin-api-provide")
public interface ISysUserService {

    @GetMapping("/sysuser/getByLoginName")
    SysUserVO getByLoginName(@RequestParam("loginName") String loginName);

    @GetMapping("/sysuser/getPage")
    PageInfo<SysUserVO> getPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize);
}
