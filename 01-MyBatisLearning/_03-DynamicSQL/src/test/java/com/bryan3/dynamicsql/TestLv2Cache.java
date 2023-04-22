package com.bryan3.dynamicsql;

import com.bryan3.dao.EmpMapper;
import com.bryan3.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class TestLv2Cache {
    // 二级缓存：SqlSessionFactory级别
    // 1. 需要手动开启
    // 2. 需要在mapper文件中，创建cache标签
    // 3. 实体类必须实现序列化接口
    // 4. SqlSession必须提交或关闭

    // 测试二级缓存生效条件
    @Test
    public void testLv2Cache1() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder build = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = build.build(in);
        SqlSession sqlSession1 = factory.openSession(true);
        SqlSession sqlSession2 = factory.openSession(true);

        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);

        Emp emp1 = mapper1.selectEmpById(2);
        // 手动提交，将查询的结果放到二级缓存中
        sqlSession1.commit();

        Emp emp2 = mapper2.selectEmpById(2);

        System.out.println(emp1);
        System.out.println(emp2);

        sqlSession1.close();
        sqlSession2.close();
    }
}
