package com.wyh.demo.kafka.serializer;

import com.wyh.demo.domain.Company;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;

/**
 * @author imai
 * @since 2020/12/1 下午11:04
 */
public class CompanySerializer implements Serializer<Company> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Company data) {
        if(data == null){
            return null;
        }
        byte[] name,address;
        try{
            if(data.getName() != null){
                name = data.getName().getBytes();
            }else{
                name = new byte[0];
            }
            if(data.getAddress() != null){
                address = data.getAddress().getBytes();
            }else{
                address = new byte[0];
            }
            ByteBuffer buffer = ByteBuffer.allocate(4+4+name.length+address.length);
            buffer.putInt(name.length);
            buffer.put(name);
            buffer.putInt(address.length);
            buffer.put(address);
            return buffer.array();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
