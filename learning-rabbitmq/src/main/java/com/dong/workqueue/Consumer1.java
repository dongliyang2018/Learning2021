package com.dong.workqueue;

import com.dong.util.RabbitMqUtil;
import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class Consumer1 {
    
    private static final Logger logger = LoggerFactory.getLogger(Consumer1.class);

    public static void main(String[] args) throws IOException, TimeoutException{
        //获取连接对象
        Connection connection = RabbitMqUtil.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();

        String queue = "work";
        //通道绑定对应消息队列
        channel.queueDeclare(queue, /*持久化*/true
                , /*是否独占队列*/false, /*是否在消费完成后自动删除队列*/false,
                null);

        //每次只消费一个消息
        channel.basicQos(1);
        channel.basicConsume(queue, false,new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }
                logger.info("消费者1:" + new String(body));
                //手动确认
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}
