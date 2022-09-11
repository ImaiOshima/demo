package com.wyh.demo.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 * @Classname HBaseJavaClient
 * @Description TODO
 * @Date 2022/7/28 23:44
 * @Created by 61635
 */
public class HBaseJavaClient {
    private static Configuration getConfiguration(){
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.rootdir","hdfs://102.168.31.198:9000/hbase");
        conf.set("hbase.zookeeper.quorum","192.168.31.198");
        return conf;
    }
}
