package com.wyh.demo.copy;

import lombok.ToString;

/**
 * @author imai
 * @since 2021/3/12 7:46 下午
 */
@ToString
public class Teacher implements Cloneable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
