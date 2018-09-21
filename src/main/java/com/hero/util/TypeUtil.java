package com.hero.util;


/**
 * 类型转换工具类
 * @author chenwenwei
 * @time 2018.09.18
 */
public class TypeUtil {

    //char类型转换成int类型(转换成int类型的前提下是一个数字类型)
    public static int charTOint(char charNumbe){
        //与ASCii码有关
        int intNumber=charNumbe - '0';
        //在输出结果里面将int类型转换成Integer的目的是因为instanceof不知道基本类型比较
        System.out.println("char转int之后的结果intNumber:"+intNumber+"======>>>它是int类型"+((Integer)intNumber instanceof Integer));
        return intNumber;
    }

    //int类型转船成char类型
    public static char intTOchar(int intNumber){
        //与ASCii码有关
        char charNumber = (char) (intNumber + '0');
        //在输出结果里面乘以9的原因是验证char类型，只有2个整型想成才得到对的结果
        System.out.println("int转char之后的结果charNumber:"+charNumber*9);
        return charNumber;
    }

    public static void  main(String[] args){
        char a='1';
        charTOint(a);
    }

}
