package com.wyh.demo.controller;

import com.wyh.demo.domain.Item;
import com.wyh.demo.service.CachePassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author imai
 * @since 2021/4/11 9:07 下午
 */
@RestController
@Slf4j
public class CachePassController {
    private static final String prefix = "cache/pass";

    @Autowired
    private CachePassService cachePassService;

    @GetMapping(value = prefix + "/item/info")
    public Map<String, Object> getItem(@RequestParam String itemCode) {
        Map<String, Object> resMap = new HashMap<>(10);
        resMap.put("code", 0);
        resMap.put("msg", "成功");
        try {
            resMap.put("data", cachePassService.getItemInfo(itemCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resMap;
    }

    @GetMapping(value = prefix + "/item/info/get")
    public Item getItem2(@RequestParam String itemCode) {
        Item item = null;
        try{
            item = cachePassService.getItemInfo2(itemCode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
