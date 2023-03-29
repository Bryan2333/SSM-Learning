package com.bryan.mybatis.test;

import com.bryan.dao.UserMapper;
import com.bryan.pojo.User;
import com.bryan.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) {

    }
    @Test
    public void testInsertUser() throws IOException {
        // 获取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 构造一个 SqlSessionFactoryBuilder
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 构造一个SqlSession
        // SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true); // 自动提交事务

        // 获取一个接口的实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 执行sql语句
        int rows = mapper.insertUser();

        if (rows == 1) {
            System.out.println("插入数据成功");
        }

        // sqlSession.commit();
        sqlSession.close();
    }

    // 修改id为1的用户的余额，将其改为2000
    @Test
    public void updateUserById() {

        SqlSession sessionSql = SqlSessionUtil.getSqlSession("mybatis-config.xml");

        UserMapper mapper = sessionSql.getMapper(UserMapper.class);
        int row = mapper.updateUserById();

        if (row == 1) {
            System.out.println("修改余额成功");
        }

        sessionSql.commit();
        sessionSql.close();
    }


    // 删除id为3的用户
    @Test
    public void deleteUserById() {
        SqlSession sessionSql = SqlSessionUtil.getSqlSession("mybatis-config.xml");

        UserMapper mapper = sessionSql.getMapper(UserMapper.class);
        int row = mapper.deleteUserById();

        if (row == 1) {
            System.out.println("删除用户成功");
        }

        sessionSql.commit();
        sessionSql.close();
    }


    // 查询id为1的用户信息
    @Test
    public void selectUserById() {
        SqlSession sessionSql = SqlSessionUtil.getSqlSession("mybatis-config.xml");

        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        User user = mapper.selectUserById();
        System.out.println(user);

        sessionSql.close();
    }

    // 查询所有用户
    @Test
    public void selectAllUser() {
        SqlSession sessionSql = SqlSessionUtil.getSqlSession("mybatis-config.xml");

        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        List<User> users = mapper.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }

        sessionSql.close();
    }
}
