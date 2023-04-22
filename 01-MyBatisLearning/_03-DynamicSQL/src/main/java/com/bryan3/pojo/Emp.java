package com.bryan3.pojo;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer eid; // 员工编号
    private String empName; // 员工姓名
    private Integer age; //员工年龄

    private String job; // 员工工作

    private Double salary; // 员工薪资

    private Integer deptId;

    public Emp() {}

    public Emp(Integer eid, String empName, Integer age, String job, Double salary, Integer deptId) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.job = job;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eId) {
        this.eid = eId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "{eid=%d, empName=%s, age=%s, job=%s, salary=%f, deptId=%d}".formatted
                (eid, empName, age, job, salary, deptId);
    }
}
