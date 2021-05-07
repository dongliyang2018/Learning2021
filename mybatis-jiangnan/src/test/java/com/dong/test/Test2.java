package com.dong.test;

import com.dong.mapper.UserMapper;
import com.dong.model.User;
import com.dong.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 测试二级缓存
 * @version 1.0 2021/5/3
 * @author dongliyang
 */
public class Test2 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        sqlSessionFactory = SqlSessionFactoryUtils.getInstance();
    }

    @Test
    public void test2() {
        //一级缓存，在同一个sqlSession有效
        //二级缓存，在同一个sqlSessionFactory有效
        SqlSession session1 = sqlSessionFactory.openSession();
        UserMapper um1 = session1.getMapper(UserMapper.class);
        User user = um1.getUserById(1L);
        System.out.println("user = " + user);
        user.setUsername("test_username");
        session1.close();

        SqlSession session2 = sqlSessionFactory.openSession();
        UserMapper um2 = session2.getMapper(UserMapper.class);
        User u2 = um2.getUserById(1L);
        System.out.println("u2 = " + u2);
    }
}
