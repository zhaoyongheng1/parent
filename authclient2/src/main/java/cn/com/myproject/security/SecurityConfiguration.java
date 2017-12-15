package cn.com.myproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

/**
 *
 */
@Configuration
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/","/login")
                .and().authorizeRequests().antMatchers("/private/**").authenticated()
                .and().formLogin().loginPage("/login").permitAll().and()
                .csrf().disable();
    }

    @Autowired
    private AuthorizationCodeResourceDetails authorizationCodeResourceDetails;


    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {

        OAuth2RestTemplate restTemplate =
                new OAuth2RestTemplate(authorizationCodeResourceDetails, new DefaultOAuth2ClientContext());

        return restTemplate;
    }
}
