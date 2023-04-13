package com.bryan2.test;

import com.bryan2.dao.DeptMapper;
import com.bryan2.pojo.Dept;
import com.bryan2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

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
}
