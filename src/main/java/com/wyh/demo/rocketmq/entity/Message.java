package com.wyh.demo.rocketmq.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author imai
 * @since 2021/5/16 3:21 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message<T> implements Serializable {
    private String id;
    private T content;
}
