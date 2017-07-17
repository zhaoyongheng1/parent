package cn.com.myproject.user.service;

import cn.com.myproject.user.entity.VO.MenuVO;

import java.util.Set;

/**
 * Created by liyang-macbook on 2017/7/11.
 */
public interface IResourceService {

    /**
     *根据用户ID获取用户对应的菜单
     * */
    Set<MenuVO> getMenu(String menuId,String userId);

}
