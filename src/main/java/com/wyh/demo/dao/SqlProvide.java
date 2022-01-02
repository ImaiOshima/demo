package com.wyh.demo.dao;

/**
 * @author imai
 */
public class SqlProvide {
    public StringBuilder findAllUser(){
        return new StringBuilder("SELECT * FROM USER");
    }
}
