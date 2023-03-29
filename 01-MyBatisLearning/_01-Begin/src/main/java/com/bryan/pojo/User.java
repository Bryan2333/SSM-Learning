package com.bryan.pojo;

/*
*   对应tb_user表的实体类
*
*   一条记录对于一个实体类对象
*/

public class User {
    private int id;
    private String username;
    private String password;
    private double account;
    private String permission;

    public User(int id, String username, String password, double account, String permission) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String toString() {
        return ("id=%d, username=%s, password=%s, " +
                "account=%f, permission=%s").formatted(id, username, password, account, permission);
    }
}
