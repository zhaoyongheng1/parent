package cn.waicaibao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Created by liyang-macbook on 2016/11/27.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyPermissionEvaluator implements PermissionEvaluator{
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        boolean accessable = false;
        String privilege = o+"_"+o1;
        for(GrantedAuthority authority:authentication.getAuthorities()){
           if(authority.getAuthority().equals(privilege)){
               accessable = true;
               break;
           }
        }
        return accessable;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
