package com.dong.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testBasic() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "hello work");
        }
    }

    @Test
    public void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "hello fanout");
    }

    @Test
    public void testRouting() {
        rabbitTemplate.convertAndSend("logs.direct", "info", "[info]--hello routing");
        rabbitTemplate.convertAndSend("logs.direct", "warn", "[warn]--警告消息");
    }

    @Test
    public void testTopic() {
        rabbitTemplate.convertAndSend("user.topic", "user.save", "user.save消息");
        rabbitTemplate.convertAndSend("user.topic", "user.update.admin", "user.update.admin消息");
    }
}
