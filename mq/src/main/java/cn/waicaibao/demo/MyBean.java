package cn.waicaibao.demo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.annotation.Queue;
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
    private final RabbitTemplate amqpTemplate;

    @Autowired
    public MyBean(AmqpAdmin amqpAdmin,RabbitTemplate amqpTemplate){
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
        amqpAdmin.declareQueue(QueueBuilder.durable("userid").build());
        //amqpAdmin.declareExchange(ExchangeBuilder.directExchange("demo").build());
        amqpTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(ack){
                    System.out.println("消息确认成功");
                }else{
                    System.out.println("消息确认失败");
                }
            }
        });
        amqpTemplate.setMandatory(true);
        amqpTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("================");
                System.out.println("message = " + message);
                System.out.println("replyCode = " + replyCode);
                System.out.println("replyText = " + replyText);
                System.out.println("exchange = " + exchange);
                System.out.println("routingKey = " + routingKey);
                System.out.println("================");
            }
        });
    }




    //@RabbitListener(queues = "userid")
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "userid",durable = "true"),
            exchange = @org.springframework.amqp.rabbit.annotation.Exchange(value= "demo"),
            key = "userid.*"
    ))
    public void processMessage(Message message,String content){
        System.out.println(content+"-------------------------------------------------");
    }

    public boolean sendMessage(String exchange, String routingKey, String message){
        Exchange _exchange = ExchangeBuilder.topicExchange(exchange).build();
        amqpAdmin.declareExchange(_exchange);


      //  amqpAdmin.declareQueue(QueueBuilder.durable("userid").build());
      //  amqpAdmin.declareBinding(BindingBuilder.bind(QueueBuilder.durable("userid").build()).to(_exchange).with("userid.*").noargs());
        amqpTemplate.send(exchange,routingKey, MessageBuilder.withBody(message.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN).build());

        return true;
    }
}
