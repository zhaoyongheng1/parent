package cn.waicaibao;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.waicaibao.config.MyLogoutHandler;
import com.sun.xml.internal.messaging.saaj.util.MimeHeadersUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.csrf.*;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@RequestMapping("/dashboard")
public class SsoApplication {

	@RequestMapping("/message")
	public Map<String, Object> dashboard() {
		return Collections.<String, Object> singletonMap("message", "Yay!");
	}

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}



	@Bean
	public OAuth2RestTemplate restTemplate(UserInfoRestTemplateFactory factory) {
		return factory.getUserInfoRestTemplate();
	}


	@Autowired
	private OAuth2RestOperations restTemplate;

	@RequestMapping("/relay")
	public String relay() {

		ResponseEntity<Integer> response =
				restTemplate.getForEntity("http://192.168.2.230:3333/a1/add?a=1&b=2", Integer.class);
		return "Success! (" + response.getBody() + ")";
	}

	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}

	@Controller
	public static class LoginErrors {

		@RequestMapping("/dashboard/login")
		public String dashboard() {
			return "redirect:/#/";
		}

	}

	@Component
	@EnableOAuth2Sso
	public static class LoginConfigurer extends WebSecurityConfigurerAdapter {

		@Resource
		private MyLogoutHandler myLogoutHandler;
		@Override
		public void configure(HttpSecurity http) throws Exception {
			SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
			handler.setDefaultTargetUrl("http://127.0.0.1:8888/uaa/logout");
			http.authorizeRequests()
					.antMatchers("/dashboard/**","/demo1")
					.authenticated()
					.and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class).csrf().csrfTokenRepository(csrfTokenRepository())
					.and()
					.logout()
					//.logoutUrl("/dashboard/logout")
					.deleteCookies("XSRF-TOKEN")
					.addLogoutHandler(myLogoutHandler)
					.logoutRequestMatcher(new AntPathRequestMatcher("/dashboard/logout"))
					//.logoutSuccessHandler(handler)
					.permitAll()
					.logoutSuccessUrl("/")

			;
		}

		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		}

		private Filter csrfHeaderFilter() {
			return new OncePerRequestFilter() {
				@Override
				protected void doFilterInternal(HttpServletRequest request,
												HttpServletResponse response, FilterChain filterChain)
						throws ServletException, IOException {
					CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
					if (csrf != null) {

							Cookie cookie = new Cookie("XSRF-TOKEN",csrf.getToken());
							cookie.setPath("/");
							response.addCookie(cookie);

					}
					filterChain.doFilter(request, response);
				}
			};
		}

		private CsrfTokenRepository csrfTokenRepository() {
			CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
			repository.setHeaderName("X-XSRF-TOKEN");
			repository.setCookieHttpOnly(false);
			return repository;
		}
	}


}
