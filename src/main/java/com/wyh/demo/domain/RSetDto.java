package com.wyh.demo.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @author imai
 * @since 2021/4/5 10:52 下午
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RSetDto implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private Double score;

    public RSetDto(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
