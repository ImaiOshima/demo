package com.wyh.demo.beanlive.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author imai
 * @since 2021/1/24 5:01 下午
 */
public class JdkProxy implements InvocationHandler {
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理 监听开始");
        Object result = method.invoke(target,args);
        System.out.println("JDK动态代理 监听结束");
        return result;
    }

    private Object getJDKProxy(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        user.addUser("admin","123123");
    }
}
