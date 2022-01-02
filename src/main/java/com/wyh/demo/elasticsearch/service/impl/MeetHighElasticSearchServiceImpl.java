package com.wyh.demo.elasticsearch.service.impl;

import com.wyh.demo.elasticsearch.service.MeetHighElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.ReindexRequest;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author imai
 * @since 2021/4/17 2:23 下午
 */
@Service
@Slf4j
public class MeetHighElasticSearchServiceImpl implements MeetHighElasticSearchService {
    private RestHighLevelClient restHighLevelClient;

    private final static String TITLE = "title";

    @PostConstruct
    @Override
    public void initEs() {
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.0"
            + ".105", 9200, "http")));
        log.info("192.168.0.105", 9200, "http");
    }

    @Override
    public void closeEs() {
        try {
            restHighLevelClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildIndexRequestWithString(String indexName, String document) {
        // 索引名称
        IndexRequest request = new IndexRequest(indexName);
        //文档ID
        request.id(document);
        //String 类型的文档
        String jsonString = "{" + "\"user\":\"niudong\"," + "\"postDate\":\"2019-07-20\"," + "\"message\":\"Hello "
            + "ElasticHello\"" + "}";
        request.source(jsonString, XContentType.JSON);
    }

    @Override
    public void indexDocument(String indexName,String document){
        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source("user","niudong","postDate",
                new Date(),"message","Hello ElasticSearch");
        try{
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest,
                RequestOptions.DEFAULT);
            processIndexResponse(indexResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            restHighLevelClient.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override public void getIndexDocument(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName,document);
        try{
            GetResponse getResponse = restHighLevelClient.get(getRequest,RequestOptions.DEFAULT);
            processGetResponse(getResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override public void getIndexDocumentsAsync(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName,document);
        ActionListener<GetResponse> listen = new ActionListener<GetResponse>() {
            @Override public void onResponse(GetResponse o) {
                String id = o.getId();
                String index = o.getIndex();
                log.info("id is " + id + ", index is "+index);
            }

            @Override public void onFailure(Exception e) {
            }
        };
        try{
            restHighLevelClient.getAsync(getRequest,RequestOptions.DEFAULT,listen);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override public void checkExistIndexDocument(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName,document);
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        try{
            boolean exists = restHighLevelClient.exists(getRequest,RequestOptions.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
        }
        closeEs();
    }

    @Override public void deleteIndexDocuments(String indexName, String document) {
        DeleteRequest request = new DeleteRequest(indexName,document);
        try {
            DeleteResponse deleteResponse = restHighLevelClient.delete(request,RequestOptions.DEFAULT);
            processDeleteRequest(deleteResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void updateIndexDocuments(String indexName, String document) {
        UpdateRequest request;
        Map<String,Object> map = new HashMap<>();
        map.put("updated",new Date());
        map.put("reason","Year update!");
        map.put("content","2015年12月，美联储");
        request = new UpdateRequest(indexName,document).doc(map);
        try {
            UpdateResponse response = restHighLevelClient.update(request,RequestOptions.DEFAULT);
            processUpdateResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void executeBulkRequest(String indexName, String field) {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest(indexName).id("1").source(XContentType.JSON,field,"事实上，"));
        request.add(new IndexRequest(indexName).id("2").source(XContentType.JSON,field,"自6月起"));
        request.add(new IndexRequest(indexName).id("3").source(XContentType.JSON,field,"从此前"));

        try {
            BulkResponse response = restHighLevelClient.bulk(request,RequestOptions.DEFAULT);
            processBulkResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void executeBulkProcessor(String indexName, String field) {
        BulkProcessor.Listener listener = new BulkProcessor.Listener() {
            @Override public void beforeBulk(long executionId, BulkRequest request) {
                int numberOfActions = request.numberOfActions();
                log.info("Executing bulk" + executionId+" with " + numberOfActions + " request");
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                if(response.hasFailures()){
                    log.info("Bulk " + executionId + " executed with failures");
                }else{
                    log.info("Bulk "+executionId+" completed in " + response.getTook().getMillis()+"Milliseconds");
                }
            }

            @Override
            public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                log.error("Failed to execute bulk",failure);
            }
        };
        BulkProcessor bulkProcessor = BulkProcessor.builder((request,bulkListener)->
            restHighLevelClient.bulkAsync(request, RequestOptions.DEFAULT,bulkListener),
            listener).build();
        IndexRequest one = new IndexRequest(indexName).id("6").source(XContentType.JSON,TITLE,
            "8月1日");
        IndexRequest two = new IndexRequest(indexName).id("7").source(XContentType.JSON,TITLE,
            "在两分钟");
        IndexRequest three = new IndexRequest(indexName).id("8").source(XContentType.JSON,TITLE,
            "宣传片正式");
        bulkProcessor.add(one);
        bulkProcessor.add(two);
        bulkProcessor.add(three);
    }

    @Override public void executeReindex(String fromIndexName, String toIndexName) {
        ReindexRequest request = new ReindexRequest();
        request.setSourceIndices(fromIndexName);
        request.setDestIndex(toIndexName);
        try {
            BulkByScrollResponse bulkResponse = restHighLevelClient.reindex(request,
                RequestOptions.DEFAULT);
            processBulkByScrollResponse(bulkResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processIndexResponse(IndexResponse indexResponse){
        String index = indexResponse.getIndex();
        String id = indexResponse.getId();
        log.info("index is " + index + ", id is " + id);
        if(indexResponse.getResult() == DocWriteResponse.Result.CREATED){
            log.info("Document is created");
        }else if(indexResponse.getResult() == DocWriteResponse.Result.UPDATED){
            log.info("Document is update");
        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if(shardInfo.getTotal() != shardInfo.getSuccessful()){
            log.info("Successe shards are not enough");
        }
        if(shardInfo.getFailed() > 0){
            for(ReplicationResponse.ShardInfo.Failure failure: shardInfo.getFailures()){
                String reason = failure.reason();
                log.info("Fail reason" + reason);
            }
        }
    }

    public void processGetResponse(GetResponse getResponse){
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        log.info("id is " + id + ", index is "+ index);
        if(getResponse.isExists()){
            long version = getResponse.getVersion();
            String sourceAsString = getResponse.getSourceAsString();
            Map<String,Object> sourceAsMap = getResponse.getSourceAsMap();
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();
            log.info("version is " + version + ", sourceAsString is " + sourceAsString);
        }
    }

    public void processDeleteRequest(DeleteResponse deleteResponse){
        String index = deleteResponse.getIndex();
        String id = deleteResponse.getId();
        long version = deleteResponse.getVersion();
        log.info("delete id is " + id + ", index is "+ index + ", version is " + version);
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if(shardInfo.getTotal() != shardInfo.getSuccessful()){
            log.info("Success shards are not enough");
        }
        if(shardInfo.getFailed() > 0){
            for(ReplicationResponse.ShardInfo.Failure failure:shardInfo.getFailures()){
                String reason = failure.reason();
                log.info("Fail reason is " + reason);
            }
        }
    }

    public void processUpdateResponse(UpdateResponse response){
        String index = response.getIndex();
        String id = response.getId();
        long version = response.getVersion();
        log.info("update id is " + id + ", index is " + index + ",version is" + version);
        if(response.getResult() == DocWriteResponse.Result.CREATED){

        }else if(response.getResult() == DocWriteResponse.Result.UPDATED){
            log.info(response.getResult().toString());
        }else if(response.getResult() == DocWriteResponse.Result.DELETED){

        }else if(response.getResult() == DocWriteResponse.Result.NOOP){

        }
    }

    public void processBulkResponse(BulkResponse response){
        if(response == null){
            return;
        }
        for(BulkItemResponse bulkItemResponse:response){
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();
            switch (bulkItemResponse.getOpType()){
                case INDEX:
                    break;
                case CREATE:
                    IndexResponse indexResponse = (IndexResponse)itemResponse;
                    String index = indexResponse.getIndex();
                    String id = indexResponse.getId();
                    long version = indexResponse.getVersion();
                    log.info("create id is " + id + ",index is " + index + ", version is " + version );
                    break;
                case UPDATE:
                    UpdateResponse updateResponse = (UpdateResponse)itemResponse;
                    break;
                case DELETE:
                    DeleteResponse deleteResponse = (DeleteResponse)itemResponse;
                    break;
            }
        }
    }

    public void processBulkByScrollResponse(BulkByScrollResponse response){
        if(response == null){
            return;
        }
        //总耗时时间
        TimeValue timeTaken = response.getTook();
        log.info("time is " + timeTaken.getMillis());
        //检查是否已经timedout
        boolean timedOut = response.isTimedOut();
        log.info("timedOut is " + timedOut);
        //总文档数
        long totalDocs = response.getTotal();
        //已更新的次数
        long updateDocs = response.getUpdated();
        log.info("updated is " + updateDocs);
        //已创建的次数
        long created = response.getCreated();
        log.info("created is " + created);
        //已删除的次数
        long deletedDocs = response.getDeleted();
        log.info("deleted is " + deletedDocs);
        //已执行的次数
        long batches = response.getBatches();
        log.info("batches is " + batches);
        //已跳过的文档数
        long noops = response.getNoops();
        log.info("noops is " + noops);
        //版本冲突
        long versionConflict = response.getDeleted();
        log.info("versionConflict is " + versionConflict);
        //
    }

}
