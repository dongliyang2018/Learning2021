package com.dong.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * @version 1.0 2021/5/11
 * @author dongliyang
 */
@Component
public class WorkConsumer {

    /*
     *@RabbitListener即可以标注在类上，也可以标注在方法上
     */
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }
}
