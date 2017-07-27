package cn.com.myproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liyang-macbook on 2017/7/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AdminApiProvideApplication {

    @Autowired
    private RestTemplateBuilder builder;


    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminApiProvideApplication.class, args);
    }
}
