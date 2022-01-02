package com.wyh.demo;

import com.wyh.demo.domain.HomeProperties;
import com.wyh.demo.domain.PersonProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@MapperScan(basePackages="com.wyh.demo.dao")
public class DemoApplication implements CommandLineRunner {

    @Autowired
    HomeProperties homeProperties;
    @Autowired
    PersonProperties personProperties;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(homeProperties.toString());
        System.out.println(personProperties.toString());
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("80MB");
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
    }

}
