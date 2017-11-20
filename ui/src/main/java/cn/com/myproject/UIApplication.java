package cn.com.myproject;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
//@EnableRedisHttpSession
public class UIApplication {



	@Bean
	public OAuth2RestTemplate restTemplate(OAuth2ProtectedResourceDetails resource,OAuth2ClientContext oauth2ClientContext) {
		return new OAuth2RestTemplate(resource, oauth2ClientContext);
	}
//	@Bean
//	//@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}


}
