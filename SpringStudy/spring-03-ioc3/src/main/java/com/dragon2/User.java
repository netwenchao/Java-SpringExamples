package com.dragon2;

/**
 * @author yanchongsheng
 * @since 2022-08-03
 */
public class User {
    private String name;

    public User() {
        System.out.println("User 的无参构造方法");
    }

    public User(String name) {
        this.name = name;
        System.out.println("User 的有参构造方法" + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name " + name);
    }
}
