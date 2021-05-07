package com.dong.springaoptest;

import com.dong.springaoptest.service.CalService;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringAopTestApplicationTests {
    
    private final Logger logger = LoggerFactory.getLogger(SpringAopTestApplicationTests.class);
    
    @Autowired
    private CalService calService;

	@Test
	public void contextLoads() {
	}

	@Test
    public void testAop() {
	    logger.info("Spring版本:" + SpringVersion.getVersion() + ",SpringBoot版本:" + SpringBootVersion.getVersion());
//        int divide = calService.divide(10, 5);
        int divide = calService.divide(10, 0);
        logger.info("执行结果:" + divide);
    }
}
