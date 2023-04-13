package com.bryan2.test;

import com.bryan2.dao.EmpMapper;
import com.bryan2.pojo.Emp;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmp {

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

    // 查询所有员工信息 (开启驼峰命名映射)
    @Test
    public void selectAllEmpCamel() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectAllEmpCamel();
        for (Emp emp : employees) {
            System.out.println(emp);
        }

        sessionSql.close();
    }

    // 查询所有员工信息 (使用ResultMap映射)
    @Test
    public void selectAllEmpMap() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectAllEmpMap();
        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    // 根据id查询员工信息及其所在部门名 (使用级联属性赋值)
    @Test
    public void selectEmpAndDeptByEid() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpAndDeptByEid(1);
        System.out.println(emp);

        sessionSql.close();
    }

    // 根据id查询员工信息及其所在部门名 (使用association标签赋值)
    @Test
    public void selectEmpAndDeptByEidAssociation() {
        SqlSession session = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpAndDeptByEidAssociation(1);
        System.out.println(emp);

        session.close();
    }

    // 根据id查询员工信息及其所在部门名 (分步查询)
    @Test
    public void selectEmpAndDeptByEidByStep() {
        SqlSession session = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpAndDeptByEidByStep(1);
        System.out.println(emp);

        session.close();
    }

    // 测试延迟加载
    @Test
    public void testLazyLoading() {
        SqlSession session = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = session.getMapper(EmpMapper.class);

        Emp emp = mapper.selectEmpAndDeptByEidByStep(1);
        System.out.println(emp.getEmpName()); // 不会执行第二步，即查询部门信息

        session.close();
    }
}
