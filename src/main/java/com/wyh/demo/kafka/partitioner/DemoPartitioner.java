package com.wyh.demo.kafka.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.utils.Utils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author imai
 * @since 2020/12/2 上午12:21
 */
public class DemoPartitioner implements Partitioner {
    private final AtomicInteger counter = new AtomicInteger();


    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int partitionNum = cluster.partitionCountForTopic(topic);
        if(null == keyBytes){
            return counter.getAndIncrement() % partitionNum;
        }else{
            return Utils.toPositive(Utils.murmur2(keyBytes)) % partitionNum;
        }
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
