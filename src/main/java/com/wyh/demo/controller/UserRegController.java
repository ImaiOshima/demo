package com.wyh.demo.controller;

import com.wyh.demo.dao.StatusCode;
import com.wyh.demo.domain.BaseResponse;
import com.wyh.demo.domain.UserRegDto;
import com.wyh.demo.service.UserRegService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/4/21 8:59 下午
 */
@RestController
@Slf4j
public class UserRegController {
    private static final String prefix = "/user/reg";

    @Autowired
    private UserRegService userRegService;

    @RequestMapping(value=prefix+"/submit",method = RequestMethod.GET)
    public BaseResponse reg(UserRegDto dto){
        if(Strings.isNullOrEmpty(dto.getUserName()) || Strings.isNullOrEmpty(dto.getPassword())){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            userRegService.userRegWithLock(dto);
        }catch (Exception e){
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }
}
