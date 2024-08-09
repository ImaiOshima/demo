package com.wyh.demo.forwork.controller;

import com.wyh.demo.config.ds.DataBase;
import com.wyh.demo.forwork.service.TransTestService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransTestController {
    @Autowired
    TransTestService transTestService;

    @GetMapping("transTest")
    @DataBase("db1")
    public String transTest(){
        transTestService.transTest();
        return "ok";
    }
}
