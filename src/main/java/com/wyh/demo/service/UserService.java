package com.wyh.demo.service;

import com.wyh.demo.domain.User;

import java.util.List;

/**
 * @author imai
 */
public interface UserService {
    User findOneUserById(Long id);

    List<User> findAllUser();

    List<User> findOneUserJob(String id);

    void saveUser(User user);

    Object saveOne(User user);

    List<User> list();

}
