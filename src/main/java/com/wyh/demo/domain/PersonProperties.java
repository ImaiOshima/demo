package com.wyh.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:person.properties"})
public class PersonProperties {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;
    @Value("${person.sex}")
    private String sex;

    @Override
    public String toString() {
        return "PersonProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
