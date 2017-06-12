package cn.waicaibao;

import cn.waicaibao.demo.MyBean;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class MqApplication {


	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);
	}
}
