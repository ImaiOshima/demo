package com.wyh.demo.controller;

import com.google.common.collect.Maps;
import com.wyh.demo.dao.StatusCode;
import com.wyh.demo.domain.BaseResponse;
import com.wyh.demo.domain.praise.PraiseDto;
import com.wyh.demo.service.IPraiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author imai
 * @since 2021/4/20 10:21 下午
 */
@RestController
@Slf4j
public class PraiseController {
    private static final String prefix = "/blog/praise";
    @Autowired
    private IPraiseService praiseService;

    @RequestMapping(value=prefix + "/add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse addPraise(@Validated @RequestBody PraiseDto praiseDto){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap = Maps.newHashMap();
        try{

        }catch(Exception e){
            log.error("点赞发生异常 {}",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = prefix + "/cancel",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse cancelPraise(@RequestBody PraiseDto praiseDto){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap = Maps.newHashMap();
        try{

        }catch (Exception e){
            log.error("取消点赞 发生异常 {}",e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
