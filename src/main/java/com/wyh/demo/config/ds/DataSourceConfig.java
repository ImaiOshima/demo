package com.wyh.demo.config.ds;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "db1.datasource")
    public DataSource db1Source(){
        return DataSourceBuilder.create().build();
    }

    @Bean("db2")
    @ConfigurationProperties(prefix="db2.datasource")
    public DataSource db2Source(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("DynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(db1Source());
        Map<Object,Object> dbMap = new HashMap(5);
        dbMap.put("db1",db1Source());
        dbMap.put("db2",db2Source());
        dataSource.setTargetDataSources(dbMap);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
