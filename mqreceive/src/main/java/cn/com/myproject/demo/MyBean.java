package cn.com.myproject.demo;

import com.rabbitmq.http.client.domain.ExchangeType;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by liyang-macbook on 2016/12/12.
 */
@Component
public class MyBean {

    private final AmqpAdmin amqpAdmin;

    @Autowired
    public MyBean(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
        amqpAdmin.declareQueue(QueueBuilder.nonDurable("demo1").build());
        amqpAdmin.declareQueue(QueueBuilder.nonDurable("demo2").build());

    }


    @RabbitListener(queues = "demo1")
    public void processMessage(Message message,String content){

        System.out.println(content+"-------------------------------------------------");

    }


//    @RabbitListener(queues = "demo2")
//   // @SendTo("demo2.reply/demo2.reply")
//    public String processMessage1(Message message,String content){
//        System.out.println(content+"+-------------------------------------------------");
//        return "success1";
//    }
    @RabbitListener(queues = "demo2")
    // @SendTo("demo2.reply/demo2.reply")
    public void processMessage1(Message message,String content){
        System.out.println(content+"+-------------------------------------------------");
    }

}
