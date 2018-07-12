package com.hero.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * servlet
 * @author chenwenwei
 * @time 2018.05.14
 */

public class HttpCoder {

    /**
     * 通过post的方式获取参数
     * @param inputStream
     * @return
     */
    public static String GetParamPost(InputStream inputStream) throws IOException {
        //通过post读取请求内容
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        String line=null;
        StringBuffer stringBuffer=new StringBuffer();
        while((line= br.readLine())!=null){
            stringBuffer.append(line);
        }
        //将资料进行解码
        String getParam=stringBuffer.toString();
        return URLDecoder.decode(getParam,"utf-8");
    }
}
