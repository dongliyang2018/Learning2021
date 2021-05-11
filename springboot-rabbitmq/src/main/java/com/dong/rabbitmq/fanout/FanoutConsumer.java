package com.dong.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @version 1.0 2021/5/11
 * @author dongliyang
 */
@Component
public class FanoutConsumer {

    //@RabbitListener即可以标注在类上，也可以标注在方法上
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    //相当于创建了两个消费者
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
