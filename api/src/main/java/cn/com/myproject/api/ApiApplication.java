package cn.com.myproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liyang-macbook on 2017/6/27.
 */
@SpringBootApplication
@EnableRedisHttpSession
public class ApiApplication {

    @Autowired
    private RestTemplateBuilder builder;


    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
