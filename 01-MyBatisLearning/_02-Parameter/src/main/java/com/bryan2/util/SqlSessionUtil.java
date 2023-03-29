package com.bryan2.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSessionSql(String path) {
        SqlSessionFactory factory;
        try {
            InputStream in = Resources.getResourceAsStream(path);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return factory.openSession(true); //自动提交事务
    }
}
