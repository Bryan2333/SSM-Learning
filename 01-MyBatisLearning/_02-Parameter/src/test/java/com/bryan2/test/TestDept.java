package com.bryan2.test;

import com.bryan2.dao.DeptMapper;
import com.bryan2.pojo.Dept;
import com.bryan2.pojo.Emp;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDept {
    // 根据部门编号查询部门信息
    @Test
    public void selectDeptById() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        DeptMapper mapper = sessionSql.getMapper(DeptMapper.class);

        Dept dept = mapper.selectDeptById(1);
        System.out.println(dept);

        sessionSql.close();
    }

    // 查询指定部门的所有员工
    @Test
    public void selectDeptAndEmployeesById() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        DeptMapper mapper = sessionSql.getMapper(DeptMapper.class);

        Dept dept = mapper.selectDeptAndEmployeesById(1);
        List<Emp> employees = dept.getEmployees();
        for (Emp employee : employees) {
            System.out.println(employee.info());
        }

        sessionSql.close();
    }

    // // 查询指定部门的所有员工 (分步查询)
    @Test
    public void selectDeptAndEmployeesByStep() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        DeptMapper mapper = sessionSql.getMapper(DeptMapper.class);

        Dept dept = mapper.selectDeptAndEmployeesByStepOne(1);
        List<Emp> employees = dept.getEmployees();
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }
}
