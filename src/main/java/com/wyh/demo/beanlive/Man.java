package com.wyh.demo.beanlive;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author imai
 * @since 2021/2/7 10:19 下午
 * 1.实例化对象 2.设置对象属性 3.如果继承了些Aware接口 就会实现这些接口
 * 4.
 */
@Component
public class Man implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
        DisposableBean {

    /**
     * 实例化 第一步
     */
    public Man(){
        System.out.println("第一步:Man被实例化");
    }

    private String name;
    /**
     * 设置对象属性 第二步
     * @param name
     */
    public void setName(String name) {
        System.out.println("第二步:setName");
        this.name = name;
    }

    /**
     * 如果实现了BeanNameAware接口 第三步
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("第三步:setBeanName " + name);
    }

    /**
     * 如果实现了BeanFactoryAware接口 第四步
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第四步:setBeanFactory");
    }

    /**
     * 如果实现了ApplicationContextAware 第五步
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第五步:setApplicationContext");
    }

    /**
     * 如果实现了BeanPostProcessor 第六步 初始化前处理器 在初始化之前实现
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("第六步:postProcessBeforeInitialization");
//        return null;
//    }

    /**
     * 如果实现了InitializingBean 第七步
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第七步:afterPropertiesSet");
    }

    /**
     * 初始化方法 第八步
     */
    public void init_method(){
        System.out.println("init_method");
    }

    /**
     *  如果实现了BeanPostProcessor 第九步 初始化后处理器 在初始化之后实现
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }

    /**
     * bean的使用 第十步
     */
    public void hello(){
        System.out.println("hello");
    }

    /**
     * 如果实现了DisposableBean方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("第十一步:destroy");
    }

    /**
     * 自定义销毁方法
     */
    public void init_destroy(){
        System.out.println("第十二步");
    }

}
