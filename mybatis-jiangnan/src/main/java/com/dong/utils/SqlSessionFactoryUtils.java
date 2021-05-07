package com.dong.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getInstance() {
        if(sqlSessionFactory == null) {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
