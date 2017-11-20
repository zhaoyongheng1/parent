package cn.com.myproject.service;

import cn.com.myproject.sysuser.entity.VO.MenuVO;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * Created by liyang-macbook on 2017/7/26.
 */
@FeignClient("admin-api-provide")
public interface ISysResourceService {

    @GetMapping("/sysresource/getMenu")
    Set<MenuVO> getMenu(@RequestParam("menuId") String menuId,@RequestParam("userId") String userId);

}


