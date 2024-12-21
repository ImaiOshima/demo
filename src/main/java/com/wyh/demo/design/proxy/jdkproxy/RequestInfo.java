package com.wyh.demo.design.proxy.jdkproxy;

import lombok.Data;
import lombok.ToString;

/**
 * Project Name: demo
 * File Name: null.java
 * Author: 61635
 * Date: 2024/11/17
 * Description: [这里写该文件的简要描述]
 */
@Data
@ToString
public class RequestInfo {
    private String apiName;
    private int responseTime;
    private String startTime;
    private String endTime;
}
