package com.bryan2.dao;

import com.bryan2.pojo.Dept;
import org.apache.ibatis.annotations.Param;

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
}
