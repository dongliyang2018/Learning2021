package com.dong;

import com.dong.basic.Consumer;
import com.dong.basic.Provider;
import com.dong.workqueue.Consumer1;
import com.dong.workqueue.Consumer2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试RabbitMQ
 * @version 1.0 2021/5/10
 * @author dongliyang
 */
public class TestRabbitMQ {

    private final Logger logger = LoggerFactory.getLogger(TestRabbitMQ.class);
    
    @Test
    public void testProvider() {
        Provider provider = new Provider();
        try {
            provider.send();
            logger.debug("send OK");
        } catch (Exception e) {
            logger.error("Exception is:" + e.getMessage(), e);
        }
    }

    @Test
    public void testConsumer() {
        Consumer consumer = new Consumer();
        try {
            consumer.consume();
            logger.debug("consume OK");
        } catch (Exception e) {
            logger.error("Exception is:" + e.getMessage(), e);
        }
    }
}
