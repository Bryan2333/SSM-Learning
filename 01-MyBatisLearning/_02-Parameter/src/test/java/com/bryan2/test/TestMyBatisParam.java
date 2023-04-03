package com.bryan2.test;

import com.bryan2.dao.UserMapper;
import com.bryan2.pojo.User;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestMyBatisParam {
    public static void main(String[] args) {

    }

    // 统计用户数量
    @Test
    public void selectCount() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        Integer result = mapper.selectCount();

        System.out.println("总记录数 = " + result);

        sessionSql.close();
    }

    // 查询所有姓张的用户
    @Test
    public void selectUserByName() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        List<User> users = mapper.selectUserByName("张");

        for (User user : users) {
            System.out.println(user);
        }

        sessionSql.close();
    }

    // 动态查询列名
    @Test
    public void selectUserByCol() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        List<User> users = mapper.selectUserByCols("*");

        for (User user : users) {
            System.out.println(user);
        }

        sessionSql.close();
    }

    // 获取添加记录后自增的 id 值
    @Test
    public void insertUserByIns() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        User bob = new User(null, "Bob", "1233", 1111, "sys:user:select");

        int row = mapper.insertByUserIns(bob);

        System.out.println(row == 1 ? bob : "添加数据失败");

        sessionSql.close();
    }
}
