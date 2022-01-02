package com.wyh.demo.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author imai
 * @since 2021/3/17 10:53 下午
 * 泛型擦除
 */
public class TestGenerics {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        list.getClass().getMethod("add",Object.class).invoke(list,"asd");

       for(int i = 0;i<list.size();++i){
           System.out.println(list.get(i));
       }
       TestGenerics testGenerics = new TestGenerics();
       List<Integer> dest = new ArrayList<>();
       List<Integer> src = new ArrayList<>();
       testGenerics.test(dest,src);
    }

    public <T extends Number> void test1(List<T> dest, List<T> src){
        System.out.println(dest);
        System.out.println(src);
    }

    public void test(List<? extends Number> dest, List<? extends Number> src){
        System.out.println(dest);
        System.out.println(src);
    }
}
