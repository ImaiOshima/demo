package com.wyh.demo.config.ds;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DataBase {
    String value() default "db1";
}
