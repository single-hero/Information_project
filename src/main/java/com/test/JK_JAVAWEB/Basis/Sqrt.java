package com.test.JK_JAVAWEB.Basis;

import java.text.SimpleDateFormat;

/**
 * 变量简化计算
 * @author chenwenwei
 * @time 2018.10.10
 */
public class Sqrt {

    public static void main(String[] args){
        //Math.sqrt()得到一个平方根
        double Num1=(Math.sqrt(20)+Math.sqrt(10))/((Math.sqrt(20))-(Math.sqrt(10)));

        //Math.round()把一个数字舍入为最接近的整数
        long RoundNum1=Math.round(Num1);
        System.out.println(RoundNum1);
        //通过Math.round来进行保留小数后几位
        long RoundNum2=Math.round(10*Num1/10.0);
        System.out.println(RoundNum2);


        //获取系统时间
        long systemTime=System.currentTimeMillis();

        //时间戳转日期，代替年月日时分秒字母大小写是固定的
        SimpleDateFormat YMD=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(YMD.format(systemTime));
    }
}
