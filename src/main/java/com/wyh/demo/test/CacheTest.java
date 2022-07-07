package com.wyh.demo.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @Classname CacheTest
 * @Description TODO
 * @Date 2022/7/6 19:27
 * @Created by 61635
 */
public class CacheTest {
    public static void main(String[] args) {
        LoadingCache<String,String> lc = CacheBuilder.newBuilder().removalListener(x-> System.out.println(x)).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return method(key);
            }
        });
    }

    static String method(String key){
        return key + ".result";
    }
}
