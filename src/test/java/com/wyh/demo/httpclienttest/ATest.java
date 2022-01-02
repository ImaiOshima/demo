package com.wyh.demo.httpclienttest;

import com.wyh.demo.httpclient.A;
import com.wyh.demo.httpclient.B;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * @author imai
 * @since 2021/5/19 10:20 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ATest {
    @Autowired
    @InjectMocks
    private A a;
    @Mock
    B b;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(b.getAge()).thenReturn(2);
        when(b.getName()).thenReturn("AAA");
    }

    @Test
    public void test(){
        Assert.assertEquals(a.get(),2);
        Assert.assertEquals(a.name(),"AAA");
        verify(b,times(1)).getAge();
        verify(b,times(1)).getName();
    }
}
