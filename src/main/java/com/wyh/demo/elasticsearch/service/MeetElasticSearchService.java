package com.wyh.demo.elasticsearch.service;

/**
 * @author imai
 * @since 2021/4/9 11:30 下午
 */
public interface MeetElasticSearchService {
    void initEs();
    void closeEs();
    String executeRequest();
    String buildRequestAsync();
    void parseElasticsearchResponse();
}
