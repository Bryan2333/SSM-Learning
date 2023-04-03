package com.bryan2.pojo;

public class Emp {
    private Integer eid; // 员工编号
    private String empName; // 员工姓名
    private Integer age; //员工年龄

    private String job; // 员工工作

    private Double salary; // 员工薪资

    public Emp() {}

    public Emp(Integer eid, String empName, Integer age, String job, Double salary) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.job = job;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Emp {" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
