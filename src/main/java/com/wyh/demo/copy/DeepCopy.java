package com.wyh.demo.copy;

/**
 * @Classname DeepCopy
 * @Description TODO
 * @Date 2022/7/18 23:42
 * @Created by 61635
 */
public class DeepCopy {
    public static void main(String[] args) {
        Author author = new Author();
        author.setName("1");
        author.setAge(1);

        Book book = new Book();
        book.setName("2");
        book.setAuthor(author);

        Book book1 = (Book) book.clone();
        System.out.println("拷贝后");
        System.out.println(book);
        System.out.println(book1);

        System.out.println("修改老师的信息");

        author.setName("Games");
        author.setAge(3);
        System.out.println(book);
        System.out.println(book1);
    }
}
