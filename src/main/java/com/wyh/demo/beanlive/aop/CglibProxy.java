package com.wyh.demo.beanlive.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author imai
 * @since 2021/1/24 5:26 下午
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理 监听开始");
        Object invoke = method.invoke(target,objects);
        System.out.println("Cglib动态代理 监听结束");
        return invoke;
    }

    public Object getCglibProxy(Object objectTarget){
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserManager user = (UserManager) cglibProxy.getCglibProxy(new UserManagerImpl());
        user.delUser("admin");
    }
}
