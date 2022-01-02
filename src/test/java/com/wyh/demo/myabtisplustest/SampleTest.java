package com.wyh.demo.myabtisplustest;

import com.wyh.demo.dao.UserMapper;
import com.wyh.demo.domain.User1;
import com.wyh.demo.util.red.RedPacketUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author imai
 * @since 2021/3/31 8:52 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        System.out.println("---select method test--");
        List<User1> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void one(){
        Integer amount = 1000;
        Integer total = 10;
        List<Integer> list = RedPacketUtil.divideRedPackage(amount,total);
        log.info("总金额={}分,总个数={}个",amount,total);
        Integer sum = 0;
        for(Integer i:list){
            log.info("随机金额：{}分,即{}元",i,new BigDecimal(i.toString()).divide(new BigDecimal(100)));
            sum +=i;
        }
        log.info("叠加之和={}分",sum);
    }
}
