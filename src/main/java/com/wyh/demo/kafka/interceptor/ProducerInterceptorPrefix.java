package com.wyh.demo.kafka.interceptor;

import com.wyh.demo.domain.Company;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author imai
 * @since 2020/12/2 上午12:54
 */
public class ProducerInterceptorPrefix implements ProducerInterceptor<String, Company> {
    private volatile long sendSuccess = 0;
    private volatile long sendFailure = 0;
    @Override
    public ProducerRecord<String, Company> onSend(ProducerRecord<String, Company> record) {
        Company company = record.value();
        String name = "prefix" + company.getName();
        String address = "prefix" + company.getAddress();
        company.setName(name);
        company.setAddress(address);
        return new ProducerRecord<>(record.topic(), record.partition(), record.timestamp(), record.key(), company,
            record.headers());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if(exception == null){
            sendSuccess++;
        }else{
            sendFailure++;
        }
    }

    @Override
    public void close() {
        double successRatio = (double)sendSuccess / (sendSuccess + sendFailure);
        System.out.println(String.format("%f",successRatio * 100));
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
