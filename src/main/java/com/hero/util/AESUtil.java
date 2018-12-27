package com.hero.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Aes加解密类
 * @author chenwenwei
 * @time 2018.12.25
 */
public class AESUtil {
    /**
     * Logger for this class
     */
    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    @Value("${KEY_iv}")
    private String key_iv1;

    public static String time=String.valueOf(System.currentTimeMillis()).substring(0,6);
    public static String IV ="";

    /*******************************************************************
     * AES加密算法
     * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，虽然不会错，至于怎么裁决，个人看情况而定    此处使用AES-128-CBC加密模式，key需要为16位。
     * */

    //加密
    public String Encrypt(String sSrc, String sKey) throws Exception {
        System.out.println(key_iv1);
        IV=time+key_iv1;
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes();

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());

        return Base64.encodeBase64String(encrypted);//此处使用BAES64做转码功能，同时能起到2次
    }


    //解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {

        // 判断Key是否正确
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("ASCII");

        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted1 = Base64.decodeBase64(sSrc);//先用bAES64解密
        try {
            System.out.println("进来");
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString;
        } catch (Exception e) {
            logger.info(e.toString());
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        String cKey = "dvyYRQlnPRCMdQSe";
        // 需要加密的字串
        String cSrc = "{'loginname':'中','psw':'23'}";
        System.out.println(cSrc);
        // 加密
//        String enString = AESUtil.Encrypt(cSrc, cKey);
//        System.out.println("加密后的字串是：" + enString);
//
//        // 解密
//        String DeString = AESUtil.Decrypt(enString, cKey);
//        System.out.println("解密后的字串是：" + DeString);
    }
}
