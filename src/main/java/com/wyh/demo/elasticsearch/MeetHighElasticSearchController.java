package com.wyh.demo.elasticsearch;

import com.wyh.demo.elasticsearch.service.MeetHighElasticSearchService;
import org.elasticsearch.common.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imai
 * @since 2021/4/17 3:36 下午
 */
@RestController
@RequestMapping("/springboot/es/high")
public class MeetHighElasticSearchController {
    @Autowired
    private MeetHighElasticSearchService meetHighElasticSearchService;

    @RequestMapping("/index/put")
    public String putIndexInHighElasticSearch(String indexName,String document){
        if(Strings.isNullOrEmpty(indexName) || Strings.isNullOrEmpty(document)){
            return "Parameters are error!";
        }
        meetHighElasticSearchService.indexDocument(indexName,document);
        return "Index High ElasticSearch Client Successes!";
    }

    @RequestMapping(value = "/index/get")
    public String getIndexInHighElasticSearch(String indexName,String document){
        if(Strings.isNullOrEmpty(indexName) || Strings.isNullOrEmpty(document)){
            return "error";
        }
        meetHighElasticSearchService.getIndexDocument(indexName,document);
        return "Get index";
    }

    @RequestMapping(value = "/index/check")
    public String getIndexExists(String indexName,String document){
        if(Strings.isNullOrEmpty(indexName) || Strings.isNullOrEmpty(document)){
            return "error";
        }
        meetHighElasticSearchService.getIndexDocument(indexName,document);
        return "Get index";
    }

    @RequestMapping("/index/delete")
    public String deleteIndexInHighEs(String indexName,String document){
        if(Strings.isNullOrEmpty(indexName) || Strings.isNullOrEmpty(document)){
            return "Parameters are error";
        }
        meetHighElasticSearchService.deleteIndexDocuments(indexName,document);
        return "Delete Index High ElasticSearch Client Successed";
    }

    @RequestMapping("/index/update")
    public String updateIndexDocuments(String indexName,String document){
        if(Strings.isNullOrEmpty(indexName)||Strings.isNullOrEmpty(document)){
            return "Parameters are error!";
        }
        meetHighElasticSearchService.updateIndexDocuments(indexName,document);
        return "Update Index High ElasticSearch Client Successed";
    }

    @RequestMapping("/index/bulk")
    public String bulkGetInHighEs(String indexName,String field){
        if(Strings.isNullOrEmpty(indexName)||Strings.isNullOrEmpty(field)){
            return "Parameters are error!";
        }
        meetHighElasticSearchService.executeBulkRequest(indexName,field);
        return "Bulk Get In High ElasticSearch Client Successed";
    }

    @RequestMapping("/index/bulkProcessor")
    public String bulkProcessorInHighEs(String indexName,String field){
        if(Strings.isNullOrEmpty(indexName) || Strings.isNullOrEmpty(field)){
            return "Parameters are error!";
        }
        meetHighElasticSearchService.executeBulkProcessor(indexName,field);
        return "BulkProcessor Get In High ElasticSearch Client Successed";
    }

    @RequestMapping("/index/reindex")
    public String reindexInHighEs(String fromIndexName,String toIndexName){
        if(Strings.isNullOrEmpty(fromIndexName) || Strings.isNullOrEmpty(toIndexName)){
            return "Parameters are error!";
        }
        meetHighElasticSearchService.executeReindex(fromIndexName,toIndexName);
        return "Reindex In High ElasticSearch Client Successed";
    }
}
