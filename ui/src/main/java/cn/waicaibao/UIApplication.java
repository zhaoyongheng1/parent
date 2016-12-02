package cn.waicaibao;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableRedisHttpSession
public class UIApplication {

//	@Bean
//	OAuth2RestOperations restTemplate() {
//		return new OAuth2RestTemplate(new ClientCredentialsResourceDetails());
//	}

	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}


}
