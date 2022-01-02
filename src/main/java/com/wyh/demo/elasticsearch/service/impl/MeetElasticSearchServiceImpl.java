package com.wyh.demo.elasticsearch.service.impl;

import com.wyh.demo.elasticsearch.service.MeetElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author imai
 * @since 2021/4/9 11:31 下午
 */
@Service
@Slf4j
public class MeetElasticSearchServiceImpl implements MeetElasticSearchService {

    private RestClient restClient;

    @Override
    @PostConstruct
    public void initEs() {
        restClient = RestClient.builder(new HttpHost("192.168.0.105", 9200, "http")).build();
        log.info("ElasticSearch init in service");
    }

    /** 配置请求头 */
    public void initEsWithHeader(){
        RestClientBuilder builder = RestClient.builder(new HttpHost("192.168.0.105", 9200, "http"));
        Header[] defaultsHeaders = new Header[]{new BasicHeader("header","value")};
        builder.setDefaultHeaders(defaultsHeaders);
    }

    @Override
    public void closeEs() {
        try{
            restClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String executeRequest(){
        Request request = new Request("GET","/");
        try{
            Response response = restClient.performRequest(request);
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            restClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Get result failed";
    }

    @Override
    public String buildRequestAsync(){
        Request request = new Request("GET", "/");
        restClient.performRequestAsync(request, new ResponseListener() {
            @Override
            public void onSuccess(Response response) {

            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
        try{
            restClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Get result failed";
    }

    @Override
    public void parseElasticsearchResponse(){
        try{
            Response response = restClient.performRequest(new Request("GET","/"));
            RequestLine responseLine = response.getRequestLine();
            HttpHost host = response.getHost();
            int status = response.getStatusLine().getStatusCode();
            Header[] headers = response.getHeaders();
            String responseBody = EntityUtils.toString(response.getEntity());
            log.info("parse ElasticSearch Response,response is:"+responseBody);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
