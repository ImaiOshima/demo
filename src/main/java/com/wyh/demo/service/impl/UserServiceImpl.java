package com.wyh.demo.service.impl;

import com.wyh.demo.config.ds.DataBase;
import com.wyh.demo.dao.UserDao;
import com.wyh.demo.domain.User;
import com.wyh.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @DataBase("db1")
    public User findOneUserById(Long id) {
        return userDao.findOneUserById(id);
    }

    @Override
    @DataBase("db1")
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public List<User> findOneUserJob(String id) {
        return userDao.getOneUserJob(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override public Object saveOne(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userDao.saveOne(user);
    }

    @Override public List<User> list() {
        return userDao.list();
    }

}
