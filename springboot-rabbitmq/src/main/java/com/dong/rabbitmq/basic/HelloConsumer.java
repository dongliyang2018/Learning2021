package com.dong.rabbitmq.basic;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @version 1.0 2021/5/11
 * @author dongliyang
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message = " + message);
    }
}
