package cn.com.myproject.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

/**
 * url filter，主要为自定义url过滤
 * Created by liyang-macbook on 2017/6/22.
 */
@Component("mySecurityFilter")
public class MySecurityFilter   extends AbstractSecurityInterceptor implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MySecurityFilter.class);

    @Autowired
    private CustomInvocationSecurityMetadataSourceService  mySecurityMetadataSource;

    @Resource
    private CustomAccessDecisionManager customAccessDecisionManager;

//    @Autowired
//    private AuthenticationManager authenticationManager;


    @PostConstruct
    public void init(){
   //     super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(customAccessDecisionManager);
       // super.setRejectPublicInvocations(true);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation( request, response, chain );
        invoke(fi);

    }


    public Class<? extends Object> getSecureObjectClass(){
        return FilterInvocation.class;
    }


    public void invoke( FilterInvocation fi ) throws IOException, ServletException{
        if(logger.isDebugEnabled()){
            logger.debug("filter..........................");
        }
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try{
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally{
            super.afterInvocation(token, null);
        }

    }


    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource(){
        if(logger.isDebugEnabled()){
            logger.debug("obtainSecurityMetadataSource");
        }
        return this.mySecurityMetadataSource;
    }

    @Override
    public void destroy(){
        if(logger.isDebugEnabled()){
            logger.debug("filter===========================end");
        }
    }

    @Override
    public void init( FilterConfig filterconfig ) throws ServletException{

        if(logger.isDebugEnabled()){
            logger.debug("filter===========================");
        }
    }

}
