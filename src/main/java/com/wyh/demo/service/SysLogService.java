package com.wyh.demo.service;

import com.wyh.demo.domain.UserLoginDto;
import org.springframework.stereotype.Service;

/**
 * @author imai
 * @since 2021/4/5 9:29 下午
 */
@Service
public class SysLogService {
    public void recordLog(UserLoginDto dto){
        System.out.println(dto.toString());
    }
}
