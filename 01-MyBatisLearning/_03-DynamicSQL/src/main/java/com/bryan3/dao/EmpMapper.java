package com.bryan3.dao;

import com.bryan3.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    // 查询所有员工信息
    List<Emp> selectAllEmployees();

    // 按照薪资查询员工信息
    List<Emp> selectEmployeesBySal(@Param("minSal") Double minSal, @Param("maxSal") Double maxSal);

    List<Emp> selectEmployeesBySalWhen(@Param("minSal") Double minSal, @Param("maxSal") Double maxSal);

    List<Emp> selectEmployeesBySalTrim(@Param("minSal") Double minSal, @Param("maxSal") Double maxSal);

    List<Emp> selectEmployeesBySalChoose(@Param("minSal") Double minSal, @Param("maxSal") Double maxSal);

    // 批量删除员工信息
    int deleteEmployeesBatch(@Param("eids") Integer[] eids);

    // 批量添加用户信息
    int insertEmployeesBatch(@Param("employees") List<Emp> employees);

    Emp selectEmpById(@Param("eid") Integer eid);
}
