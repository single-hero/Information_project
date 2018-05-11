package com.hero.util;


/**
 * sql-util.Date互相转换
 * @author hero
 * @time 2018.05.11
 */
public class DateChange {
//    public void sql(){
//
//    }
    // util.date转换成sql.date
    java.util.Date utilDate = new java.util.Date(); //获取当前时间
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


    // sql.date转换成util.date
    java.sql.Date sqlDate1 = new java.sql.Date(new java.util.Date().getTime());
    java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
}
