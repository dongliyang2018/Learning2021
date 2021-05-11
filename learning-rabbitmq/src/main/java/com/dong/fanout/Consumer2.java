package com.dong.fanout;

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
public class Consumer2 {
    
    private static final Logger logger = LoggerFactory.getLogger(Consumer2.class);

    public static void main(String[] args) throws IOException, TimeoutException{
        //获取连接对象
        Connection connection = RabbitMqUtil.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();

        String exchangeName = "logs";
        //通道绑定交换机
        channel.exchangeDeclare(exchangeName, "fanout");

        //创建临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queueName, exchangeName, "");

        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                logger.info("消费者2：" + new String(body));
            }
        });
    }
}
