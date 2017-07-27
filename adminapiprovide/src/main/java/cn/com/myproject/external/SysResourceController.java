package cn.com.myproject.external;

import cn.com.myproject.sysuser.entity.VO.MenuVO;
import cn.com.myproject.sysuser.service.ISysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by liyang-macbook on 2017/7/26.
 */
@RestController
@RequestMapping("/sysresource")
public class SysResourceController {

    @Autowired
    private ISysResourceService sysResourceService;

    @GetMapping("/getMenu")
    public Set<MenuVO> getMenu(String menuId, String userId) {
        return sysResourceService.getMenu(menuId,userId);
    }
}
