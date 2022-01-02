package com.wyh.demo.config.ds;

public class DataSourceContextHolder {
   public static final String DEFAUT_DB = "db1";
   public static final ThreadLocal<String> context = new ThreadLocal<>();
   public static void setDB(String dbType){
       context.set(dbType);
   }
   public static String getDB(){
       return context.get();
   }
   public static void clearDB(){
       context.remove();
   }
}
