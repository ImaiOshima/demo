package com.wyh.demo.domain;

import lombok.Data;

@Data
public class MyFactoryBeanDomain {
    private String message;

    public MyFactoryBeanDomain(String message) {
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }
}
