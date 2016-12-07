package cn.waicaibao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author Moritz Schulze
 */
@Configuration
@EnableResourceServer
public class OAuthConfiguration extends ResourceServerConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

//        TokenStore tokenStore = new JdbcTokenStore(dataSource);
//        resources.resourceId("todo-services").tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http
//                // For some reason we cant just "permitAll" OPTIONS requests which are needed for CORS support. Spring Security
//                // will respond with an HTTP 401 nonetheless.
//                // So we just put all other requests types under OAuth control and exclude OPTIONS.
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
//                .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasScope('write')")
//                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')")
//                .and()
//                // Add headers required for CORS requests.
//                .headers().addHeaderWriter((request, response) -> {
//            response.addHeader("Access-Control-Allow-Origin", "*");
//            if (request.getMethod().equals("OPTIONS")) {
//                response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
//                response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
//            }
//        });
        http.authorizeRequests().antMatchers("/uaa/**", "/login","/info","/health").permitAll().anyRequest().authenticated();
    }
}


