package com.wyh.demo.domain.praise;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author imai
 * @since 2021/4/20 12:59 上午
 */
@Data
@ToString
public class Praise {
    private Integer id;
    private Integer blogId;
    private Integer userId;
    private Date praiseTime;
    private Integer status;
    private Integer isActive;
    private Date createdTime;
    private Date updatedTime;
}
