package com.wyh.demo.controller;

import com.wyh.demo.domain.User;
import com.wyh.demo.service.UserRegService;
import com.wyh.demo.service.UserService;
import com.wyh.demo.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author imai
 */
@RestController
public class HelloController {

    private static final String prefix = "hello";

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    UserService userService;

    @Autowired
    UserRegService userRegService;

    @GetMapping("/hello")
    public String hello(){
        redisTemplate.opsForValue().set("key","value");
        return "Hello World";
    }
    @GetMapping("/user/hello")
    public String user(){
        return "hello user";
    }

    @GetMapping("/db/hello")
    public String dba(){
        return "hello dba";
    }

    @GetMapping("/admin/hello")
    public List<User> admin(){
        return userService.findAllUser();
    }

    @PostMapping("/abc")
    public Person abc(@RequestBody Person person ){
        System.out.println(person.getName());
        return person;
    }

}
