package com.wyh.demo.copy;

import lombok.*;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2022/7/18 23:42
 * @Created by 61635
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Cloneable{
    private String name;
    private Author author;

    @Override
    public Object clone(){
        Object obj = null;
        try{
            obj = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        Book book = (Book)obj;
        book.author = (Author) book.getAuthor().clone();
        return book;
    }
}
