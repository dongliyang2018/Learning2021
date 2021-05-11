package com.dong.routing;

import com.dong.util.RabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

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

        String exchangeName = "logs.direct";
        //声明交换机
        channel.exchangeDeclare(exchangeName, "direct");
        channel.basicPublish(exchangeName, "debug", null, "debug级别的日志".getBytes());
        channel.basicPublish(exchangeName, "info", null, "info级别的日志".getBytes());
        channel.basicPublish(exchangeName, "warn", null, "warn级别的日志".getBytes());
        channel.basicPublish(exchangeName, "error", null, "error级别的日志".getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
