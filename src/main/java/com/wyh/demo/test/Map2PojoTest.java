package com.wyh.demo.test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.misc.Hash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author imai
 * @since 2022/9/8 2:19 下午
 */
public class Map2PojoTest {
    public static void main(String[] args) throws IOException {
        Map<String,Object> map = new HashMap<>();
        map.put("id",null);
        map.put("action","mainAction");
        map.put("customerOrderId","11111");
        ObjectMapper mapper = new ObjectMapper();
        String mapstr = mapper.writeValueAsString(map);

        MapToPojo a = mapper.readValue(mapstr,MapToPojo.class);
        System.out.println(a);
        System.out.println(a.getId() == null);
    }
}
