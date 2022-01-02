package com.wyh.demo.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author imai
 * @since 2021/3/24 10:46 下午
 */
public class KafkaProducerAnalysis {
    public static final String brokerList = "47.116.137.230:9092";
    public static final String topic = "topic-demo";

    public static Properties initConfig(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        props.put(ProducerConfig.CLIENT_ID_CONFIG,"producer.client.id.demo");
        props.put(ProducerConfig.RETRIES_CONFIG,10);
        return props;
    }

    public static void main(String[] args){
        Properties props = initConfig();
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(props);
        try {
            int i = 0;
            while(i<100){
                ProducerRecord<String,String> record = new ProducerRecord<>(topic,"Hello Kafka-" + i++);
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if(exception == null){
                            System.out.println(metadata.topic() + "-" + metadata.partition() + "-" +
                                    metadata.offset());
                        }else{
                            exception.printStackTrace();
                        }
                    }
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        producer.close();
    }
}
