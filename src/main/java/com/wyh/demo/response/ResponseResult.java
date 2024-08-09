package com.wyh.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)  // 序列化时，添加所有不为NULL的字段
public class ResponseResult<T> implements Serializable {

}
