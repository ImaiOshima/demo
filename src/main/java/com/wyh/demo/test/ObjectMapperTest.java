package com.wyh.demo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author imai
 * @since 2022/8/25 11:16 上午
 */
public class ObjectMapperTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = new HashMap<>();
        map.put("a","b");
        map.put("c","d");
        List<Map<String,String>> list = new ArrayList<>();
        list.add(map);
        String value = mapper.writeValueAsString(map);
        System.out.println(value);
        NewTest newTest = mapper.readValue(value,NewTest.class);
        System.out.println(newTest);
    }
}
