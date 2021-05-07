package com.dong.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SqlSessionFactory工具类
 * @version 1.0 2021/5/4
 * @author dongliyang
 */
public class SqlSessionFactoryUtil {

    private static final Logger logger = LoggerFactory.getLogger(SqlSessionFactoryUtil.class);

    private static volatile SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getInstance() {
        if(sqlSessionFactory == null) {
            synchronized (SqlSessionFactory.class) {
                if (sqlSessionFactory == null) {
                    try {
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                    } catch (Exception e) {
                        logger.error("init sqlSessionFactory error",e);
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
}
