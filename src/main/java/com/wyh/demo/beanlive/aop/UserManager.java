package com.wyh.demo.beanlive.aop;

/**
 * @author imai
 * @since 2021/1/24 4:57 下午
 */
public interface UserManager {
    void addUser(String userName,String password);

    void delUser(String userName);
}
