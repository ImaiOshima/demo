package com.wyh.demo.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wyh.demo.elasticsearch.service.MeetElasticSearchService;

/**
 * @author imai
 * @since 2021/4/9 11:28 下午
 */
@RestController
@RequestMapping("/springboot/es")
public class MeetElasticSearchController {
    @Autowired
    private MeetElasticSearchService meetElasticSearchService;

    @RequestMapping("/init")
    public String initElasticSearch(){
        meetElasticSearchService.initEs();
        return "Init ElasticSearch Over!";
    }

    @RequestMapping("/buildRequest")
    public String executeRequestForElasticSearch(){
        return meetElasticSearchService.executeRequest();
    }

    @RequestMapping("/parseEsResponse")
    public String parseElasticSearchResponse(){
        meetElasticSearchService.parseElasticsearchResponse();
        return "Parse ElasticSearch Response Is Over";
    }
}
