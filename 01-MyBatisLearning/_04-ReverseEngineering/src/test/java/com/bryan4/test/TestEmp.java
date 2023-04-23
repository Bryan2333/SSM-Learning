package com.bryan4.test;

import com.bryan4.dao.EmpMapper;
import com.bryan4.pojo.Emp;
import com.bryan4.pojo.EmpExample;
import com.bryan4.util.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmp {

    @Test
    public void selectAllEmployees() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        List<Emp> employees = mapper.selectByExample(null);

        for (Emp employee : employees) {
            System.out.println(employee);
        }

        sessionSql.close();
    }

    // 测试根据条件查询员工信息
    @Test
    public void selectEmployeesByExample() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        // 创建查询条件对象
        EmpExample empExample = new EmpExample();

        // 设置查询条件
        empExample.createCriteria().andEmpNameEqualTo("张三").andJobEqualTo("软件开发");

        // or方法之后设置的条件和前面的条件是 **或者** 关系
        empExample.or().andSalaryGreaterThanOrEqualTo(5000.0);

        List<Emp> employees = mapper.selectByExample(empExample);

        for (Emp emp : employees) {
            System.out.println(emp);
        }

        sessionSql.close();
    }

    // 测试有选择性的更新
    @Test
    public void updateEmpByPrimaryKeySelective() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        // 将eid=5的员工的薪资修改为8500
        Emp empToUpdate = new Emp(5, null, null, null, 8500.0, null);
        int rows = mapper.updateByPrimaryKeySelective(empToUpdate);

        System.out.println("受影响行数 = " + rows);

        sessionSql.close();
    }

    // 测试PageHelper
    @Test
    public void testPageHelper() {
        SqlSession sessionSql = SqlSessionUtil.getSessionSql("mybatis-config.xml");
        EmpMapper mapper = sessionSql.getMapper(EmpMapper.class);

        // 在查询前开启分页
        Page<Emp> page = PageHelper.startPage(1, 5);

        // 调用方法执行SQL语句
        List<Emp> employees = mapper.selectByExample(null);
        System.out.println(page); // page封装了当前页的数据+基础的分页数据

        for (Emp employee : employees) {
            System.out.println(employee);
        }

        // 查询后获取pageInfo
        PageInfo<Emp> empPageInfo = new PageInfo<>(employees, 5);
        System.out.println(empPageInfo);

        page.close();
        sessionSql.close();
    }
}
