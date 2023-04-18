package com.bryan2.pojo;

import java.util.List;

public class Dept {
    private Integer deptId;
    private String deptName;

    // 一个部门对应多个员工，即一对多关系，使用的类型是List
    private List<Emp> employees;

    public Dept() {}

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Dept(Integer deptId, String deptName, List<Emp> employees) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employees = employees;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }

    public String toString() {
        return "deptId=%s, deptName=%s, employees=%s".formatted(deptId, deptName, employees);
    }
}
