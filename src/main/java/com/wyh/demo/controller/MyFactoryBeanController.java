package com.wyh.demo.controller;

import com.wyh.demo.domain.MyFactoryBeanDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFactoryBeanController {

    @Autowired
    private MyFactoryBeanDomain myFactoryBeanDomain;
    @RequestMapping(value = "/factoryBean/test")
    public String test(){
        return myFactoryBeanDomain.printMessage();
    }

    @RequestMapping(value = "/factoryBean//test2")
    public String test2(){
        return "aaa";
    }
}
