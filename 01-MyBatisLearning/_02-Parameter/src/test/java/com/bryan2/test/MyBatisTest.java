package com.bryan2.test;

import com.bryan2.dao.UserMapper;
import com.bryan2.pojo.User;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MyBatisTest {
    public static void main(String[] args) {

    }

    // 按 id 查询指定用户的信息
    @Test
    public void selectUserById() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        User user = mapper.selectUserById(5);

        System.out.println(user);

        sessionSql.close();
    }

    // 验证用户名和密码
    @Test
    public void selectUserByUsernameAndPasswd() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        User user = mapper.selectUserByUsernameAndPasswd("张三", "123");

        System.out.println(user);

        sessionSql.close();
    }

    // 添加一条用户记录
    @Test
    public void insertUser() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("username", "老六");
        userMap.put("password", "22333");
        userMap.put("account", 11111);
        userMap.put("permission", "sys:user:select");
        int row = mapper.insertUserByMap(userMap);

        System.out.println(row == 1 ? "添加成功" : "添加失败");

        sessionSql.close();
    }

    // 修改一条用户记录
    @Test
    public void updateUserByClass() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        UserMapper mapper = sessionSql.getMapper(UserMapper.class);

        User user = new User(0, "测试用户",
                "3777", 2023, "sys:emp:select");

        int row = mapper.updateUserByClass(user);

        System.out.println(row == 1 ? "修改用户信息成功" : "修改用户信息失败");

        sessionSql.close();
    }
}
