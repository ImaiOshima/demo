package com.wyh.demo.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author imai
 * @since 2021/2/19 1:22 上午
 */
public class FansheDemo {
    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","wyh");
        map.put("age","12");
        mapToObject(map,Person.class);
    }

    public static Object mapToObject(Map<String,Object> map, Class<?> beanClass){
        if(map == null){
            return null;
        }
        Object bean = null;
        try {
            bean = beanClass.newInstance();
            Field[] fields = bean.getClass().getDeclaredFields();
            for(Field field : fields){
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                field.set(bean,map.get(field.get(field.getName())));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
