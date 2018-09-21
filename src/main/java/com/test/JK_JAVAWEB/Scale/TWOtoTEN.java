package com.test.JK_JAVAWEB.Scale;

import com.hero.util.TypeUtil;

/**
 * 二进制转十进制
 * @author chenwenwei
 * @time 2018.08.15
 */
public class TWOtoTEN {

    //方法1
    public static String Two_10_1(String number){
        //获取返回值长度
        int len=number.length();
        //先初始化一个int类型变量用在存储最终结果,不初始化会报没有初始化错误(not a statment)
        int results=0;
        //遍历返回值内容
        for (int i=0;i<number.length();i++) {
            //通过索引获取number的每一个字符（charAt类型是char类型）
            char numChar=number.charAt(i);
            //将char类型转换成int类型
            int intnum=TypeUtil.charTOint(numChar);
            //将每个单位的最终结果进行相加
            results+=intnum*Math.pow(2,--len);
        }
        System.out.println(number+"二进制转换成十进制的结果:"+results);
        return "方法1";
    }

    //方法2
    public static String Two_10_2(String number){

        System.out.println(Integer.parseInt(number,2));
        return "方法2";
    }


    //创建一个main方法
    public static void main(String[] args){
        //(11111111)_2=()_10
        Two_10_1("11111111");
//        Two_10_2("11111111");
    }
}
