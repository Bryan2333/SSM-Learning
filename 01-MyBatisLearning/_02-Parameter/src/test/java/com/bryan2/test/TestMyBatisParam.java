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
    }
}
