package com.dong.topic;

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

        String exchangeName = "user.topic";
        //声明交换机
        channel.exchangeDeclare(exchangeName, "topic");
        channel.basicPublish(exchangeName, "user.save", null, "保存用户".getBytes());
        channel.basicPublish(exchangeName, "user.update.admin", null, "更新管理员".getBytes());
        channel.basicPublish(exchangeName, "user", null, "查询用户".getBytes());

        RabbitMqUtil.closeChannelAndConnection(channel, connection);
    }
}
