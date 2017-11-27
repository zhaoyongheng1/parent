package cn.com.myproject;


import cn.com.myproject.security.MyUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.security.KeyPair;

/**
 * @author Thibaud Leprêtre
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisHttpSession
public class UaaServiceApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(UaaServiceApplication.class, args);
	}


	@Bean
	FilterRegistrationBean forwardedHeaderFilter() {
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new ForwardedHeaderFilter());
		filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filterRegBean;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}

	//@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
	@Configuration
	protected static class LoginConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.formLogin().loginPage("/login").permitAll()
//					.and()
//					.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
					.and().authorizeRequests().anyRequest().authenticated();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(new MyUserDetailService());
			auth.parentAuthenticationManager(authenticationManager);
		}
	}


	@Configuration
	@EnableAuthorizationServer
	protected static  class MyAuthConfiguration extends AuthorizationServerConfigurerAdapter {
		private static final Logger LOG = LoggerFactory.getLogger(MyAuthConfiguration.class);

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private DataSource dataSource;

		@Bean // 声明TokenStore实现
		public TokenStore tokenStore() {
			return new JdbcTokenStore(dataSource);
		}
		@Bean // 声明 ClientDetails实现
		public ClientDetailsService clientDetails() {
			return new JdbcClientDetailsService(dataSource);
		}

		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter() {
			JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
			KeyPair keyPair = new KeyStoreKeyFactory(
					new ClassPathResource("keystore.jks"), "foobar".toCharArray())
					.getKeyPair("test");

			converter.setKeyPair(keyPair);
			return converter;
		}

		@Bean
		public ApprovalStore approvalStore() {
			return new JdbcApprovalStore(dataSource);
		}

		@Bean
		public AuthorizationCodeServices authorizationCodeServices() {
			return new JdbcAuthorizationCodeServices(dataSource);
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {


			endpoints.tokenStore(tokenStore());
			endpoints.approvalStore(approvalStore());
			endpoints.authorizationCodeServices(authorizationCodeServices());
			endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.PUT);
			endpoints.setClientDetailsService(clientDetails());
			endpoints.userDetailsService(new MyUserDetailService());

			endpoints.authenticationManager(authenticationManager);
	//		endpoints.accessTokenConverter(new DefaultAccessTokenConverter());
			endpoints.accessTokenConverter(jwtAccessTokenConverter());

			LOG.info("==========="+endpoints.getAccessTokenConverter());
			LOG.info("==========="+endpoints.getApprovalStore());
			LOG.info("==========="+endpoints.getAuthorizationCodeServices());
			LOG.info("==========="+endpoints.getTokenServices());
			LOG.info("==========="+endpoints.getTokenStore());
			LOG.info("==========="+endpoints.getTokenGranter());
			LOG.info("==========="+endpoints.getTokenEnhancer());


		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.withClientDetails(clientDetails());
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		}
	}

}
