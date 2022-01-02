package com.wyh.demo.design.proxy;

/**
 * @author imai
 * @since 2021/2/13 9:23 下午
 */
public class RealObject extends AbstractObject{
    @Override
    public void operation() {
        System.out.println("做了些操作");
    }
}
