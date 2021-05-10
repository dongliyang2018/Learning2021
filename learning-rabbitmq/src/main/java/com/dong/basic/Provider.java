package com.dong.basic;

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

    public void send() throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = RabbitMqUtil.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();

        //通道绑定对应消息队列
        //持久化队列
        channel.queueDeclare("hello", /*持久化*/true
                , /*是否独占队列*/false, /*是否在消费完成后自动删除队列*/false,
                null);
        //发布消息
        channel.basicPublish("", "hello", /* 持久化消息 */MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbitmq".getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
