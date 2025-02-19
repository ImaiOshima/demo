package com.wyh.demo.advice;

import com.baomidou.mybatisplus.extension.api.R;
import com.wyh.demo.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value=NullPointerException.class)
    public ResponseResult exceptionHandler(HttpServletRequest req,NullPointerException e){
        log.error("发生空指针！原因是：",e);
        return null;
    }

    @ExceptionHandler(value= DataAccessException.class)
    public ResponseEntity<?> handleDataAccessException(DataAccessException e){
        return ResponseEntity.badRequest().body("数据库错误：" + e.getLocalizedMessage());
    }
}
