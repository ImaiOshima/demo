package com.wyh.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyh.demo.domain.User;
import com.wyh.demo.service.UserService;
import com.wyh.demo.token.TokenService;
import com.wyh.demo.token.annotate.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

//    @GetMapping("/user")
//    public void createInfo(){
//        RBucket<String> keyObj =  stringRedissonClient.getBucket("key");
//        keyObj.set("key1");
//    }

    @GetMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.findOneUserById(user.getId());
        if(userForBase == null){
            jsonObject.put("message","登录失败");
            return jsonObject;
        }else{
            if(!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码不对");
                return jsonObject;
            }else{
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token",token);
                jsonObject.put("user",userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public Object getMessage(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","你已经成功登录");
        return jsonObject;
    }

    @PostMapping(value="save-user")
    public Object saveUser(){
        return userService.saveOne(new User("小小","女",13));
    }

    @GetMapping(value="list-user")
    public Object listUser(){
        return userService.list();
    }
}
