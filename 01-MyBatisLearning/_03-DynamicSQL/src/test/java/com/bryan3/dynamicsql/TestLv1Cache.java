package com.bryan3.dynamicsql;

import com.bryan3.dao.EmpMapper;
import com.bryan3.pojo.Emp;
import com.bryan3.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class TestLv1Cache {
    // 一级缓存默认开启，SqlSession级别
    // 生效条件：1.同一个SqlSession对象 2.同一条SQL语句 3. 查询之间，不能有更新、清空缓存操作
    @Test
    public void testCacheLevelOne() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpById(2);
        System.out.println(emp);

        Emp emp2 = mapper.selectEmpById(2);
        System.out.println(emp2);

        sessionSql.close();
    }

    // 测试一级缓存失效的情况：不同SqlSession
    @Test
    public void testCacheLevelOne2() {
        SqlSession sessionSql1 = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        SqlSession sessionSql2 = SqlSessionUtil.getSessionSql("mybatis-config.xml");

        EmpMapper mapper1 = sessionSql1.getMapper(EmpMapper.class);
        EmpMapper mapper2 = sessionSql2.getMapper(EmpMapper.class);

        Emp emp1 = mapper1.selectEmpById(2);
        Emp emp2 = mapper2.selectEmpById(2);

        System.out.println(emp1);
        System.out.println(emp2);

        sessionSql1.close();
        sessionSql2.close();
    }

    // 测试一级缓存失效情况：不同SQL语句
    @Test
    public void testCacheLevelOne3() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        Emp emp1 = mapper.selectEmpById(2);
        Emp emp2 = mapper.selectEmpById(3);

        System.out.println(emp2);
        System.out.println(emp1);

        sessionSql.close();
    }

    // 测试一级缓存失效情况：两次查询之间存在更新操作（插入、删除、修改）
    @Test
    public void testCacheLevel04() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        // 第一次查询
        Emp emp = mapper.selectEmpById(5);
        System.out.println(emp);

        // 两次查询之间的更新操作
        int rows = mapper.deleteEmployeesBatch(new Integer[]{4});
        System.out.println("受影响行数 = " + rows);

        // 第二次查询
        emp = mapper.selectEmpById(5);
        System.out.println(emp);

        sessionSql.close();
    }

    // 测试一级缓存失效情况：两次查询之间清空了缓存
    @Test
    public void testCacheLevelOne5() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        // 第一次查询
        Emp emp = mapper.selectEmpById(5);
        System.out.println(emp);

        // 两次查询之间的清空缓存
        sessionSql.clearCache();

        // 第二次查询
        emp = mapper.selectEmpById(5);
        System.out.println(emp);

        sessionSql.close();
    }
}
