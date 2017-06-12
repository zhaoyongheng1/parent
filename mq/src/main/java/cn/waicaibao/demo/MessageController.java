package cn.waicaibao.demo;

import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liyang-macbook on 2016/12/12.
 */
@RestController
public class MessageController {

    @Autowired
    private MyBean myBean;

    @RequestMapping("/add")
    public String add(String exchange,String routingKey,String message){

         myBean.sendMessage(exchange,routingKey, message);
         return "ok";
    }

}
