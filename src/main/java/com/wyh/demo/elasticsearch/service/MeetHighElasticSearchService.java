package com.wyh.demo.elasticsearch.service;

/**
 * @author imai
 * @since 2021/4/17 2:23 下午
 */
public interface MeetHighElasticSearchService {
    void initEs();
    void closeEs();
    void buildIndexRequestWithString(String indexName,String document);
    void indexDocument(String indexName,String document);
    void getIndexDocument(String indexName,String document);
    void getIndexDocumentsAsync(String indexName,String document);
    void checkExistIndexDocument(String indexName,String document);
    void deleteIndexDocuments(String indexName,String document);
    void updateIndexDocuments(String indexName,String document);
    void executeBulkRequest(String indexName,String field);
    void executeBulkProcessor(String indexName,String field);
    void executeReindex(String fromIndexName,String toIndexName);
}
