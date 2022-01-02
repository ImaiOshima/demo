package com.wyh.demo.controller;

import com.wyh.demo.dao.StatusCode;
import com.wyh.demo.domain.BaseResponse;
import com.wyh.demo.domain.book.BookRobDto;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/4/21 10:52 下午
 */
@RestController
@Slf4j
public class BookRobController {
    private static final String prefix = "/book/rob";

    @RequestMapping(value=prefix+"/request",method = RequestMethod.POST)
    public BaseResponse takeMoney(BookRobDto dto){
        if(dto.getUserId() <= 0 || dto.getUserId() == null || Strings.isNullOrEmpty(dto.getBookNo())){
            return new BaseResponse(StatusCode.InvalidParams);
        }
        BaseResponse response = new BaseResponse(StatusCode.Success);

        return response;
    }
}
