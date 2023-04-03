package com.bryan2.test;

import com.bryan2.dao.EmpMapper;
import com.bryan2.pojo.Emp;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmp {
    public static void main(String[] args) {

    }

    // 查询所有员工的信息
    @Test
    public void selectAllEmp() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectAllEmp();

        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }
}
