package com.wyh.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2025/2/18
 * Description: [这里写该文件的简要描述]
 */
@Service
public class SqlService {
    private final JdbcTemplate jdbcTemplate;

    public SqlService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Object execute(String sql){
        String trimmedSql = sql.trim().toLowerCase();
        if(trimmedSql.startsWith("select")) {
            return jdbcTemplate.queryForList(sql);
        }else{
            return jdbcTemplate.update(sql);
        }
    }
}
