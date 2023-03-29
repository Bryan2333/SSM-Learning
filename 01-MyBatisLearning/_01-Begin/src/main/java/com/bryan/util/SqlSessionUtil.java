package com.bryan.util;

/*
*   工具类 封装测试类中的公共代码 用于获得 SqlSession 对象
*
*/

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(String path) {
        SqlSessionFactory factory;
        try {
            InputStream in = Resources.getResourceAsStream(path);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return factory.openSession();
    }
}
