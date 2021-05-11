package com.dong.fanout;

import com.dong.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

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

        String exchangeName = "logs";
        String message = "hello fanout";
        //声明交换机
        channel.exchangeDeclare(exchangeName, "fanout");
        channel.basicPublish(exchangeName, "", null, message.getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
