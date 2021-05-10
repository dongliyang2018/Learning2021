package com.dong.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 连接工具类
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class RabbitMqUtil {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqUtil.class);

    private static ConnectionFactory factory;

    static {
        //创建连接MQ的连接工厂对象
        factory = new ConnectionFactory();
        //设置连接rabbitmq主机
        factory.setHost("192.168.140.129");
        //设置端口号
        factory.setPort(5672);
        //社会连接哪个虚拟主机
        factory.setVirtualHost("/ems");
        //设置访问虚拟主机的用户名和密码
        factory.setUsername("emsadmin");
        factory.setPassword("12345678");
    }

    public static Connection getConnection() {
        try {
            //获取连接对象
            return factory.newConnection();
        } catch (Exception e) {
            logger.error("get connection exception:" + e.getMessage(), e);
            return null;
        }
    }

    public static void closeChannelAndConnection(Channel channel,Connection connection) {
        try {
            if (channel != null) {
                channel.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            logger.error("close exception:" + e.getMessage(),e);
        }
    }
}
