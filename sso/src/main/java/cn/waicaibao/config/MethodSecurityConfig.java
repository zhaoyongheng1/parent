package cn.waicaibao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by liyang-macbook on 2016/11/28.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {


    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler(){
        OAuth2MethodSecurityExpressionHandler expressionHandler = new OAuth2MethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(new PermissionEvaluator() {
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
        });
        return expressionHandler;
    }
}
