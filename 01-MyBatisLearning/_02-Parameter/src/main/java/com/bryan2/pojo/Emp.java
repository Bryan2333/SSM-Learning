package com.bryan2.pojo;

public class Emp {
    private Integer eid; // 员工编号
    private String empName; // 员工姓名
    private Integer age; //员工年龄

    private String job; // 员工工作

    private Double salary; // 员工薪资

    // 一个员工只对应一个部门，即对一关系，添加对应类型的属性即可
    private Dept dept;

    public Emp() {}

    public Emp(Integer eid, String empName, Integer age, String job, Double salary, Dept dept) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.job = job;
        this.salary = salary;
        this.dept = dept;
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

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "{eid=%s, empName=%s, age=%s, job=%s, salary=%s, dept={%s}}".formatted
                (eid, empName, age, job, salary, dept);
    }
}
