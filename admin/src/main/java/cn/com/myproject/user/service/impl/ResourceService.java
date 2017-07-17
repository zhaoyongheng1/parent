package cn.com.myproject.user.service.impl;

import cn.com.myproject.user.entity.PO.SysResource;
import cn.com.myproject.user.entity.VO.MenuVO;
import cn.com.myproject.user.mapper.ResourceMapper;
import cn.com.myproject.user.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liyang-macbook on 2017/7/11.
 */
@Service
public class ResourceService implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Set<MenuVO> getMenu(String menuId,String userId) {
        Set<SysResource> set = resourceMapper.getMenu(userId);
        if(null == set || set.size() == 0){
            return null;
        }
        LinkedHashSet<MenuVO> _set = new LinkedHashSet<>();
        convet(set,_set,menuId);
        get(_set,userId,menuId);
        return _set;
    }

    private  boolean get(Set<MenuVO> set,String userId,String menuId) {
        boolean b = false;
        for(MenuVO vo : set) {
            Set<SysResource> _set = this.resourceMapper.getMenuByResourceId(userId,vo.getId());
            if(null == _set || _set.size() == 0) {
                continue;
            }
            LinkedHashSet<MenuVO> __set = new LinkedHashSet<>();
            if(convet(_set,__set,menuId)) {
                b = true;
                vo.setOpen("open");
            }
            vo.setChilds(__set);
            if(get(__set,userId,menuId)) {
                b = true;
                vo.setOpen("open");
            }
        }

        return b;
    }

    private boolean convet(Set<SysResource> set,LinkedHashSet<MenuVO> _set,String menuId){
        boolean b = false;
        MenuVO vo = null;
        for(SysResource resource : set) {
            vo = new MenuVO(resource);
            if(resource.getResourceId().equals(menuId)) {
                vo.setActive("active");
                b = true;
            }
            _set.add(vo);
        }
        return b;
    }

}
