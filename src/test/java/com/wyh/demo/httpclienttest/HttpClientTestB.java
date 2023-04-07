package com.wyh.demo.httpclienttest;

import com.wyh.demo.httpclient.HttpClientTest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author imai
 * @since 2021/5/18 7:57 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HttpClientTestB{
    @Autowired
    @InjectMocks
    HttpClientTest httpClientTest;

    @Mock HttpClient httpClient;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        HttpResponse response = mock(HttpResponse.class);
        StatusLine statusLine = mock(StatusLine.class);
        HttpEntity httpEntity = mock(HttpEntity.class);

        when(httpClient.execute(any(HttpGet.class))).thenReturn(response);
        when(statusLine.getStatusCode()).thenReturn(200);
        when(response.getStatusLine()).thenReturn(statusLine);
        when(response.getEntity()).thenReturn(httpEntity);
    }

    @Test
    public void test() throws IOException {
        //httpClientTest.test();
    }
}
