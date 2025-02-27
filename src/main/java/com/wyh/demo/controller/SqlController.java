package com.wyh.demo.controller;

import com.wyh.demo.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2025/2/18
 * Description: [这里写该文件的简要描述]
 */
@RestController
public class SqlController {
    @Autowired
    private SqlService sqlService;

    @PostMapping("/execute-sql")
    public ResponseEntity<?> executeSql(@RequestParam String sql, @RequestParam(required = false) String param){
        try{
            Object result = sqlService.execute(sql);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
