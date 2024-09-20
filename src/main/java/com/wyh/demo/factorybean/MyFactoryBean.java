package com.wyh.demo.factorybean;

import com.wyh.demo.domain.MyFactoryBeanDomain;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyFactoryBean implements FactoryBean<MyFactoryBeanDomain> {

    @Override
    public MyFactoryBeanDomain getObject() throws Exception {
        return new MyFactoryBeanDomain("this is factoru bean test");
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBeanDomain.class;
    }
}
