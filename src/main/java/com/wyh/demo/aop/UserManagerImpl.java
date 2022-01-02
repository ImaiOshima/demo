package com.wyh.demo.aop;

/**
 * @author imai
 * @since 2021/1/24 4:58 下午
 */
public class UserManagerImpl implements UserManager{
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法！");
        System.out.println("传入参数 userName:"+userName+" password:"+password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除了的方法！");
        System.out.println("传入参数 userName:"+userName);
    }
}
