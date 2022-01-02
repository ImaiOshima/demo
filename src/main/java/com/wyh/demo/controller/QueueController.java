package com.wyh.demo.controller;

import com.wyh.demo.service.redisson.QueuePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/4/6 12:04 上午
 */
@RestController
public class QueueController {
    private static final String prefix = "queue";

    @Autowired
    private QueuePublisher queuePublisher;

//    @GetMapping(value= prefix+"/basic/msg/send")
//    public BaseResponse

}
