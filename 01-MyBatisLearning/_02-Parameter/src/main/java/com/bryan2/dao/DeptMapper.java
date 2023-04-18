package com.bryan2.dao;

import com.bryan2.pojo.Dept;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("all")
public interface DeptMapper {
    /*
    *   根据部门编号查询部门信息
    *
    *   SQL语句：
    *
    *   SELECT *
    *   FROM dept
    *   WHERE id = #{id};
    */
    Dept selectDeptById(@Param("id") int id);

    /*
    *   查询指定部门的所有员工
    *
    *   SQL语句：
    *
    *   SELECT *
    *    FROM dept
    *   LEFT JOIN emp ON dept.id = emp.dept_id
    *   WHERE id = #{id};
    *
    */
    Dept selectDeptAndEmployeesById(@Param("id") Integer id);

    Dept selectDeptAndEmployeesByStepOne(@Param("id") Integer id);
}
