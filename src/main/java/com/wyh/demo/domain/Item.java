package com.wyh.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author imai
 * @since 2021/4/11 8:28 下午
 */
@Data
@ToString
public class Item {
    private Integer id;
    private String code;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "CMT+8")
    private Date createTime;
}
