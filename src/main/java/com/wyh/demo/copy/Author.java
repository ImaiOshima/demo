package com.wyh.demo.copy;

import lombok.*;

/**
 * @Classname Author
 * @Description TODO
 * @Date 2022/7/18 23:42
 * @Created by 61635
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Cloneable {
    private String name;
    private int age;

    @Override
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
