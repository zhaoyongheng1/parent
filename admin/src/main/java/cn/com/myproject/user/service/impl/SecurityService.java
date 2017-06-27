package cn.com.myproject.user.service.impl;

import cn.com.myproject.reids.IRedisService;
import cn.com.myproject.user.entity.PO.SysResource;
import cn.com.myproject.user.mapper.ResourceMapper;
import cn.com.myproject.user.mapper.RoleMapper;
import cn.com.myproject.user.service.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by liyang-macbook on 2017/6/26.
 */
@Service
public class SecurityService implements ISecurityService {

    public static final String URL_SECURITY_KEY = "url_security";

    public static final String METHOD_SECURITY_KEY = "method_security";

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private IRedisService redisService;

    @PostConstruct
    public void init(){

        List<String> list = roleMapper.getAllUseRoleId();

        ConfigAttribute ca = null;

        Collection<ConfigAttribute> value = null;

        List<String> valueMethod = null;

        List<String> resources = resourceMapper.getAllUseValue("1");
        List<String> resourceMethods = resourceMapper.getAllUseValue("2");

        for(String resource:resources){
            value = new ArrayList<>();
            value.add(new SecurityConfig("super"));
            redisService.setHashValue(URL_SECURITY_KEY,resource,value);
        }

        for(String resource:resourceMethods){
            valueMethod = new ArrayList<>();
            valueMethod.add("super");
            redisService.setHashValue(METHOD_SECURITY_KEY,resource,valueMethod);
        }

        for (String role_id : list) {
            ca = new SecurityConfig(role_id);
            List<SysResource> query1 = resourceMapper.getValueByRoleId(role_id);
            if(null == query1 || query1.isEmpty()){
                continue;
            }
            for (SysResource res : query1) {
                if(res.getType() == 1) {
                    value = (Collection<ConfigAttribute>) redisService.getHashValue(URL_SECURITY_KEY,res.getValue());
                    value.add(ca);
                    redisService.setHashValue(URL_SECURITY_KEY,res.getValue(), value);
                }else if(res.getType() == 2) {
                    valueMethod = (List<String>) redisService.getHashValue(METHOD_SECURITY_KEY,res.getValue());
                    valueMethod.add(role_id);
                    redisService.setHashValue(METHOD_SECURITY_KEY,res.getValue(), valueMethod);
                }

            }
        }
    }
}
