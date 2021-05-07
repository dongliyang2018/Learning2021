package com.dong.springaoptest.service.impl;

import com.dong.springaoptest.service.CalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 计算ServiceImpl
 * @version 1.0 2021/5/7
 * @author dongliyang
 */
@Service
public class CalServiceImpl implements CalService {

    private final Logger logger = LoggerFactory.getLogger(CalServiceImpl.class);
    
    @Override
    public int divide(int x, int y) {
        logger.info("调用CalServiceImpl.divide方法");
        return x / y;
    }
}
