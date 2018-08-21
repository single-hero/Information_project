package com.test.JK_JAVAWEB.Scale;

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
        //遍历返回值内容
        for (int i=0;i<number.length();i++) {
            //输出结果
            System.out.println(number.charAt(i)*Math.pow(2,--len));
        }
//        System.out.println(Integer.parseInt(number,2));
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
        Two_10_2("11111111");
    }
}
