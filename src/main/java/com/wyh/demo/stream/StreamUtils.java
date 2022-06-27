package com.wyh.demo.stream;

import com.wyh.demo.domain.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname StreamUtils
 * @Description TODO
 * @Date 2022/2/26 14:34
 * @Created by 61635
 */
public class StreamUtils {

    /**
     * Java8 数组转为List
     *
     * @param arrays
     * @return
     */
    public static List<String> arrayToList1(String[] arrays) {
        List<String> result = Stream.of(arrays).collect(Collectors.toList());

        return result;
    }


    /**
     * Java8 List转为数组
     *
     * @param list
     * @return
     */
    public static String[] listToArray1(List<String> list) {
        String[] result = list.stream().toArray(String[]::new);
        Arrays.stream(result).forEach(str -> System.err.println(str));
        return result;
    }

    /**
     * Java8 List转为Map
     * ID 必须为唯一性
     *
     * @param list
     * @return
     */
    public static Map<Long, User> listToMap1(List<User> list) {
        Map<Long, User> result = list.stream().collect(Collectors.toMap(e -> e.getId(), Function.identity()));
        return result;
    }

    /**
     * Java8 List转为Map
     * ID 必须为唯一性
     *
     * @param list
     * @return
     */
    public static Map<Long, User> listToMap2(List<User> list) {
        Map<Long, User> result = list.stream().collect(Collectors.toMap(User::getId, user -> user));
        return result;
    }

    /**
     * Java8 List转为Map
     * ID重复分组
     *
     * @param list
     * @return
     */
    public static Map<Long, List<User>> listToMap3(List<User> list) {
        Map<Long, List<User>> result = list.stream().collect(Collectors.groupingBy(User::getId));
        return result;
    }

    /**
     * Java8 List转为Map
     * 根据年龄排序后，再根据ID重复分组
     *
     * @param list
     * @return
     */
    public static Map<Long, List<User>> listToMap4(List<User> list) {
        Collections.sort(list, Comparator.comparing(User::getId).thenComparing(User::getAge));
        list.forEach(System.out::println);
        System.out.println("----------------");
        Map<Long, List<User>> result = list.stream().collect(Collectors.groupingBy(User::getId));
        return result;
    }

    public static void sortList(List<User> list) {
        Collections.sort(list, Comparator.comparing(User::getId).thenComparing(User::getAge));
        list.forEach(System.out::println);
    }

    public static List<String> arrayToList2(String[] arrays) {
        List<String> result = Arrays.asList(arrays);
        return result;
    }


    public static String[] listToArray2(List<String> list) {
        String[] result = list.toArray(new String[list.size()]);
        return result;
    }
}