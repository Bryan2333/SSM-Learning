package com.bryan2.dao;

import com.bryan2.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    /*
    *   查询所有员工的信息
    *
    *   SQL语句：
    *
    *   SELECT *
    *   FROM emp;
    *
    */
    List<Emp> selectAllEmp();
}
