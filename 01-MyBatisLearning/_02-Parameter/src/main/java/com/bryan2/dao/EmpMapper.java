package com.bryan2.dao;

import com.bryan2.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("all")
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

    /*
    *   查询所有员工信息 (开启驼峰命名映射)
    *
    *   SQL语句：
    *
    *   SELECT *
        FROM emp;
    *
    */
    List<Emp> selectAllEmpCamel();

    /*
    *   查询所有员工信息 (使用ResultMap映射)
    *
    *   SQL语句：
    *
    *   SELECT *
        FROM emp;
    *
    */
    List<Emp> selectAllEmpMap();

    /*
     *   根据id查询员工信息及其所在部门ID、部门名称 (使用级联属性赋值)
     *
     *   SQL语句：
     *
     *   SELECT *
     *   FROM emp
     *            LEFT JOIN dept ON emp.dept_id = dept.id
     *   WHERE eid = #{eid};
     *
     */
    Emp selectEmpAndDeptByEid(@Param("eid") int eid);

    /*
     *   根据id查询员工信息及其所在部门ID、部门名称 (使用association标签赋值)
     *
     *   SQL语句：
     *
     *   SELECT *
     *   FROM emp
     *            LEFT JOIN dept ON emp.dept_id = dept.id
     *   WHERE eid = #{eid};
     *
     */
    Emp selectEmpAndDeptByEidAssociation(@Param("eid") int eid);

    /*
    *   根据id查询员工信息及其所在部门ID、部门名称 (分步查询)
    *
    */
    Emp selectEmpAndDeptByEidByStep(@Param("eid") int eid);

    /*
    *   通过部门id查询该部门下的所有员工共
    */
    List<Emp> selectDeptAndEmployeesByStepTwo(@Param("deptId") int deptId);
}
