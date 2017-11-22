package cn.com.myproject.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liyang-macbook on 2016/11/17.
 */
@Service
public class DemoService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://SERVER-PROVIDE/add?a=10&b=20", String.class).getBody();
    }
    public String addServiceFallback() {
        return "error";
    }
}
