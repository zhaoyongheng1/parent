package cn.com.myproject.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "cn.com.myproject")
public class ServerProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProvideApplication.class, args);
	}
}
