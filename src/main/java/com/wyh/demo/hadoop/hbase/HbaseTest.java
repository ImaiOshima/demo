package com.wyh.demo.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname HbaseTest
 * @Description TODO
 * @Date 2022/7/28 16:14
 * @Created by 61635
 */
public class HbaseTest {
    private static Configuration conf;
    private static Connection con;
    static{
        conf = HBaseConfiguration.create();
        conf.set("hbase.rootdir","hdfs://192.168.31.198:9000/hbase");
        conf.set("hbase.zookeeper.quorum","192.168.31.198");
        try{
            con = ConnectionFactory.createConnection(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        if(con == null || con.isClosed()){
            try{
                con = ConnectionFactory.createConnection(conf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    public static void close(){
        if(con != null){
            try {
                con.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTable(String tableName,String... FamilyColumn){
        TableName tn = TableName.valueOf(tableName);
        try {
            Admin admin = getCon().getAdmin();
            if(admin.tableExists(tn)){
                return;
            }
            HTableDescriptor htd = new HTableDescriptor(tn);
            for(String fc:FamilyColumn){
                HColumnDescriptor hcd = new HColumnDescriptor(fc);
                htd.addFamily(hcd);
            }
            admin.createTable(htd);
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable(String tableName){
        TableName tn = TableName.valueOf(tableName);
        try{
            Admin admin = getCon().getAdmin();
            admin.disableTable(tn);
            admin.deleteTable(tn);
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean insert(String tableName,String rowKey,String family,String qualifier,String value){
        try {
            Table t = getCon().getTable(TableName.valueOf(tableName));
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(family),Bytes.toBytes(qualifier),Bytes.toBytes(value));
            t.put(put);
            t.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
        return false;
    }

    public static boolean del(String tableName,String rowKey,String family,String qualifier){
        try {
            Table t = getCon().getTable(TableName.valueOf(tableName));
            Delete del = new Delete(Bytes.toBytes(rowKey));
            if(qualifier != null){
                del.addColumn(Bytes.toBytes(family),Bytes.toBytes(qualifier));
            }else if(family != null){
                del.addFamily(Bytes.toBytes(family));
            }
            t.delete(del);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //HBaseUti
        }
        return false;
    }
    //获取一个值
    public static String byGet(String tableName,String rowKey,String family,String qualifier){
        try {
            Table t = getCon().getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(family),Bytes.toBytes(qualifier));
            Result r = t.get(get);
            return Bytes.toString(CellUtil.cloneValue(r.listCells().get(0)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //获取一个族列的值
    public static Map<String,String> byGet(String tableName,String rowKey,String family){
        Map<String,String> result = null;
        try {
            Table t = getCon().getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addFamily(Bytes.toBytes(family));
            Result r = t.get(get);
            List<Cell> cs = r.listCells();
            result = cs.size() > 0 ? new HashMap<String,String>():result;
            for(Cell cell:cs){
                result.put(Bytes.toString(CellUtil.cloneQualifier(cell)),Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //获取多个族列的值
    public static Map<String,Map<String,String>> byGet(String tableName,String rowKey){
        Map<String,Map<String,String>> results = null;
        try {
            Table t = getCon().getTable(TableName.valueOf(tableName));
            Get get = new Get(Bytes.toBytes(rowKey));
            Result r = t.get(get);
            List<Cell> cs = r.listCells();
            results = cs.size() > 0 ? new HashMap<String,Map<String,String>>():results;
            for(Cell cell:cs){
                String familyName = Bytes.toString(CellUtil.cloneFamily(cell));
                if(results.get(familyName) == null){
                    results.put(familyName,new HashMap<String,String>());
                }
                results.get(familyName).put(Bytes.toString(CellUtil.cloneQualifier(cell)),Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
    //扫描显示全部数据
    public static List<String> scan(String tableName){
        try {
            List<String> list = new ArrayList<>();
            Admin admin = getCon().getAdmin();
            TableName tn = TableName.valueOf(tableName);
            if(!admin.tableExists(tn)){
                return list;
            }
            Table table = getCon().getTable(TableName.valueOf(tableName));
            Scan scan = new Scan();
            ResultScanner scanner = table.getScanner(scan);
            for(Result result:scanner){
                Cell[] cells = result.rawCells();
                for(Cell cl:cells){
                    System.out.println(String.format("row:%s, family:%s, qualifier:%s, qualifierValue:%s, timeStamp:%s",Bytes.toString(result.getRow()),
                            Bytes.toString(CellUtil.cloneFamily(cl)),Bytes.toString(CellUtil.cloneQualifier(cl)),Bytes.toString(CellUtil.cloneValue(cl)),cl.getTimestamp()
                            ));
                    list.add(Bytes.toString(CellUtil.cloneValue(cl)));
                }
            }
            scanner.close();
            admin.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 范围查询
    public static List<String> scanScope(String tableName,String start,String stop){
        List<String> list = new ArrayList<>();
        try {
            Admin admin = getCon().getAdmin();
            TableName tn = TableName.valueOf(tableName);
            if(!admin.tableExists(tn)){
                return list;
            }
            Table table = getCon().getTable(tn);
            Scan scan = new Scan();
            scan.setStartRow(Bytes.toBytes(start));
            scan.setStopRow(Bytes.toBytes(stop));
            scan.setBatch(1000);
            ResultScanner scanner = table.getScanner(scan);
            for(Result result:scanner){
                Cell[] cells = result.rawCells();
                for(Cell cell : cells){
                    list.add(Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
