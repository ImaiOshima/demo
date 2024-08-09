package com.wyh.demo.forwork.service;

import com.wyh.demo.forwork.mapper.TransTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class TransTestService {

    @Autowired
    TransTestMapper transTestMapper;

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,1L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());


    @Async("taskExecutor")
    public void transTest(){
        doThis();
    }

    @Transactional
    public void doThis(){
        for(int i = 1; i<=10;i++){
//                Object savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
            try {
                if(i != 5) {
                    transTestMapper.updateById(i, "wyh" + i);
                    transTestMapper.updateByName("wyh" + i, i);
                }else{
                    throw new Exception("this is error");
                }
            }catch(Exception e){
//                TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
            }
        }
    }
}
