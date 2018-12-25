package com.hero.util;

import com.aliyun.oss.OSSClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * oss上传工具类
 * @author chenwenwei
 * @time 2018.12.25
 */
public class uploadOSSUtils {
    //accessKeyId
    private String operate_accessKeyId="LTAIDRw4KCHR7Td5";
    //accessKeySecret
    private String operate_accessKeySecret="fOgnN8383WDRerldclCwKtgndSqhKe";
    //endpoint
    private String operate_endpoint="http://oss-cn-shenzhen.aliyuncs.com";
    //Bucket
    private String operate_Bucket="2018shop";

    public Object uploadFile(String url, String fileName){
        try{
            //时间年月
            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
            String yuerM=df.format(System.currentTimeMillis());
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(operate_endpoint, operate_accessKeyId, operate_accessKeySecret);

            //上传文件流
            InputStream inputStream=new FileInputStream(url);
            ossClient.putObject(operate_Bucket,"mess/"+yuerM+"/"+fileName,inputStream);

            //关闭ossClient
//            ossClient.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args){
        try{
            String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
            String accessKeyId = "LTAIDRw4KCHR7Td5";
            String accessKeySecret = "fOgnN8383WDRerldclCwKtgndSqhKe";

            //时间年月
            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
            String yuerM=df.format(System.currentTimeMillis());
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

            //上传文件流
            InputStream inputStream=new FileInputStream("E:\\upload\\uploadImg\\20180905104241.jpg");
            ossClient.putObject("2018shop","mess/"+yuerM+"/"+"20180905104241.jpg",inputStream);

            //关闭ossClient
//            ossClient.shutdown();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
