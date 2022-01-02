package com.wyh.demo.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author imai
 * @since 2021/5/18 7:31 下午
 */
@Component
public class HttpClientTest {

    private static final String url = "http://www.baidu.com1";

    HttpClient httpClient;

    public void test() throws IOException {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = null;
        response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
    }

}
