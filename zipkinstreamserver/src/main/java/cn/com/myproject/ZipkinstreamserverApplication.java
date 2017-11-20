package cn.com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer
public class ZipkinstreamserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinstreamserverApplication.class, args);
	}
}
