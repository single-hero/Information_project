package com.test.Grows;

import java.util.ArrayList;
import java.util.List;

/**
 * String类型转Object类型
 * @author chenwenwei
 * @time 2018.09.18
 */
public class StringUtil{

    //String 转换成Object
    public static String StringObject(String values){
        List<String> list=new ArrayList<>();
        String[] keyValues=values.split("&");
        for(int i=0;i<keyValues.length;i++){
            String[] toObject=keyValues[i].split("=");
            //当value值里面含有多个符合分割符号的时候需要特殊处理;
            if(keyValues[i].indexOf("test")>-1){
                String key=toObject[0];
                String value=keyValues[i].substring(key.length()+1,keyValues[i].length());
                System.out.println("keys:"+key+"=======values:"+value);
                //System.out.println("true====>>keys:"+key+"=========values:"+value);
            }
            else{
                String key=toObject[0];
                String value=toObject[1];
                System.out.println("keys:"+key+"=======values:"+value);
            }
        }
        return "success";
    }

    public static void main(String[] args){
        //特殊条件(富文本)
        String tString="a=1&b=2&c=3&test=<img src='111' style='margin-top:0,padding-top:0'>";

        //一般条件
        String sString="a=1&b=2&c=3&test=5";
        StringObject(sString);
    }
}