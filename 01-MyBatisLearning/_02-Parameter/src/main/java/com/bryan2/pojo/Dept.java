package com.bryan2.pojo;

public class Dept {
    private Integer deptId;
    private String deptName;

    public Dept(Integer id, String deptName) {
        this.deptId = id;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
