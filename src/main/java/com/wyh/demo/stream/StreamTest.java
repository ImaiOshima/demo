package com.wyh.demo.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname StreamTest
 * @Description TODO
 * @Date 2022/2/26 13:16
 * @Created by 61635
 */
public class StreamTest {
    @Test
    public void test1(){
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = stream.filter(s -> s>5).distinct().skip(2).limit(2);
        newStream.forEach(System.out::println);
    }

    @Test
    public void test2(){
        List<Integer> numbers = Arrays.asList(-1, -2, 0, 4, 5);
        long count = numbers.stream().filter( i -> i>0).count();
        System.out.println(count);
    }
}
