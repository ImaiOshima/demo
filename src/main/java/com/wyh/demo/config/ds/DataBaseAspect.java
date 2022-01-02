package com.wyh.demo.config.ds;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataBaseAspect {
    @Pointcut("@annotation(com.wyh.demo.config.ds.DataBase)")
    public void dbPointCut(){}

    @Before("dbPointCut()")
    public void beforeSwithDS(JoinPoint point){
        Class<?> className = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] argClass = ((MethodSignature)(point.getSignature())).getParameterTypes();
        String datasource = DataSourceContextHolder.DEFAUT_DB;
        try{
            Method method = className.getMethod(methodName,argClass);
            if(method.isAnnotationPresent(DataBase.class)){
                DataBase annotation = method.getAnnotation(DataBase.class);
                datasource = annotation.value();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        DataSourceContextHolder.setDB(datasource);
    }
    @After("dbPointCut()")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextHolder.clearDB();
    }
}
