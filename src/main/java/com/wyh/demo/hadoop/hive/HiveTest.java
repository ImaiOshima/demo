package com.wyh.demo.hadoop.hive;

import org.apache.log4j.Logger;

import java.sql.*;

/**
 * @Classname HiveTest
 * @Description TODO
 * @Date 2022/8/3 17:31
 * @Created by 61635
 */
public class HiveTest {
    static Logger logger = Logger.getLogger(HiveTest.class);

    public static void main(String[] args) {
        Connection conn = HiveService.getCon();
        Statement stmt = null;
        try {
            stmt = HiveService.getStmt(conn);
            stmt.execute("drop table if exists users");
            logger.debug("drop table is success");
            stmt.execute("create table users(user_id int,fname string,lname string) row format delimited fields terminated by ','");
            logger.debug("create table is success");
            stmt.execute("insert into users(user_id,fname,lname) values(222,'yang','yang2')");
            logger.debug("insert is success");
            stmt.execute("load data local inpath '/root/data/txt' into table users");
            logger.debug("load data is success");
            String sql = "select * from users";
            ResultSet res = null;
            res = stmt.executeQuery(sql);
            ResultSetMetaData meta = res.getMetaData();
            for(int i = 0;i<meta.getColumnCount();i++){
                System.out.println(meta.getColumnName(i));
            }
            System.out.println();
            while(res.next()){
                System.out.println(res.getInt(1));
                System.out.println(res.getString(2));
                System.out.println(res.getString(3));
                System.out.println();
            }
            sql = "show tables";
            System.out.println("running show tables");
            res = stmt.executeQuery(sql);
            while (res.next()){
                System.out.println(res.getString(1));
            }
            sql = "describe users";
            System.out.println("running describe users");
            res = stmt.executeQuery(sql);
            while (res.next()){
                System.out.println(res.getString(1) + "--------" + res.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HiveService.closeStmt(stmt);
        HiveService.closeConn(conn);
    }
}
