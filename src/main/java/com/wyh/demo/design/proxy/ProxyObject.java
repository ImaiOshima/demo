package com.wyh.demo.design.proxy;

/**
 * @author imai
 * @since 2021/2/13 9:24 下午
 */
public class ProxyObject extends AbstractObject{
    RealObject realObject = new RealObject();
    @Override
    public void operation() {
        System.out.println("before");
        realObject.operation();
        System.out.println("after");
    }
}
