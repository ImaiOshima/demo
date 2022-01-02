package com.wyh.demo.controller;

import com.wyh.demo.dao.StatusCode;
import com.wyh.demo.domain.BaseResponse;
import com.wyh.demo.domain.RedPacketDto;
import com.wyh.demo.service.IRedPacketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/4/17 5:56 下午
 */
@RestController
@Slf4j
public class RedPacketController {
    private static final String prefix = "/red/packet";

    @Autowired
    private IRedPacketService redPacketService;

    @RequestMapping(value=prefix+"/hand/out",method = RequestMethod.POST,consumes =
        MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse handout(@Validated @RequestBody RedPacketDto dto){
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            String redId = redPacketService.handOut(dto);
            response.setData(redId);
        }catch (Exception e){
            log.error("发红包出异常了 dto={}",dto,e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
