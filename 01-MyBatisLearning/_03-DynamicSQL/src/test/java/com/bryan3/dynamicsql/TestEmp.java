package com.bryan3.dynamicsql;

import com.bryan3.dao.EmpMapper;
import com.bryan3.pojo.Emp;
import com.bryan3.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEmp {

    // 查询所有员工信息
    @Test
    public void selectAllEmployees() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectAllEmployees();
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    // 查询工资在min和max之间的员工
    @Test
    public void selectEmployeesBySal() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectEmployeesBySal(1000.0, 5000.0);
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    @Test
    public void selectEmployeesBySalWhere() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectEmployeesBySalWhen(1000.0, 5000.0);
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    @Test
    public void selectEmployeesBySalTrim() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectEmployeesBySalTrim(1000.0, 5000.0);
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    @Test
    public void selectEmployeesBySalChoose() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectEmployeesBySalChoose(1000.0, 5000.0);
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    // 批量删除员工信息
    @Test
    public void deleteEmployeesBatch() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        int rows = mapper.deleteEmployeesBatch(new Integer[]{3, 4});

        System.out.println("受影响行数 = " + rows);

        sessionSql.close();
    }

    // 批量添加员工信息
    @Test
    public void insertEmployeesBatch() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        ArrayList<Emp> employees = new ArrayList<>();
        Emp emp1 = new Emp(null, "张三", 30, "软件开发", 9000.0, 2);
        Emp emp2 = new Emp(null, "李四", 23, "销售", 9000.0, 1);
        Emp emp3 = new Emp(null, "王五", 27, "软件开发", 8000.0, 2);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        int rows = mapper.insertEmployeesBatch(employees);
        System.out.println("受影响的行数 = " + rows);

        sessionSql.close();
    }

    // 测试SQL片段复用
    @Test
    public void selectEmpById() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpById(2);
        System.out.println(emp);

        sessionSql.close();
    }
}
