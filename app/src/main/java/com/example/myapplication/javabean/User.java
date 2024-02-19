package com.example.myapplication.javabean;

/**
 * TODO：创建库与表
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.16
 */

//设置注册的表
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{name=" + name + ", password =" + password + "}";
    }
}
