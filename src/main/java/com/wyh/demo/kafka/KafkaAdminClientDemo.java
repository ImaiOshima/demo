package com.wyh.demo.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;

/**
 * @author imai
 * @since 2021/2/11 9:55 下午
 */
public class KafkaAdminClientDemo {

    public static void main(String[] args) {
        String brokerList = "47.116.137.230:9092";
        String topic = "topic-admin";

        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(AdminClientConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);

        AdminClient client = AdminClient.create(props);

        NewTopic newtopic = new NewTopic(topic, 1, (short)1);

        CreateTopicsResult result = client.createTopics(Collections.singleton(newtopic));

        try{
            result.all().get();
        }catch (Exception e){
            e.printStackTrace();
        }
        client.close();
    }

}
