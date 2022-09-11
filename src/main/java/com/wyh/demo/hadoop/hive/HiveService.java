package com.wyh.demo.hadoop.hive;

import cn.hutool.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Classname HiveService
 * @Description TODO
 * @Date 2022/8/3 17:19
 * @Created by 61635
 */
public class HiveService {
    static Logger logger = Logger.getLogger(HiveService.class);
    public static String driverName = "org.apache.hive.jdbc.HiveDriver";
    public static String url = "jdbc:hive2://192.168.31.198:10000/default";
    public static String user = "root";
    public static String pass = "Wyh13888.";

    /**
     * 创建连接
     * @return
     */
    public static Connection getCon(){
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 创建命令
     * @param conn
     * @return
     * @throws SQLException
     */
    public static Statement getStmt(Connection conn) throws SQLException {
        logger.debug(conn);
        if(conn == null){
            logger.debug("conn is null");
        }
        return conn.createStatement();
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void closeConn(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭命令
     * @param stmt
     */
    public static void closeStmt(Statement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
