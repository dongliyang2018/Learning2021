package com.dong.workqueue;

import com.dong.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMqUtil.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();

        String queue = "work";
        String message = "hello work queue";
        //通道绑定对应消息队列
        //持久化队列
        channel.queueDeclare(queue, /*持久化*/true
                , /*是否独占队列*/false, /*是否在消费完成后自动删除队列*/false,
                null);
        for (int i = 0; i < 20; i++) {
            //发布消息
            channel.basicPublish("", queue, /* 持久化消息 */MessageProperties.PERSISTENT_TEXT_PLAIN, (message + "-" + i).getBytes());
        }

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
