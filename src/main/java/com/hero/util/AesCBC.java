package com.hero.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理
 * 对原始数据进行AES加密后，在进行Base64编码转化；
 * 正确
 */
public class AesCBC {
    //算法
    private final String ALGORITHMSTR = "AES/CBC/PKCS5Padding";
    /*已确认
    * 加密用的Key 可以用26个字母和数字组成
    * 此处使用AES-128-CBC加密模式，key需要为16位。
    */
    private static String sKey="1234567890123456";
    private static String ivParameter="1234567890123456";
    private static AesCBC instance=null;
    //private static
    private AesCBC(){

    }
    public static AesCBC getInstance(){
        if (instance==null)
            instance= new AesCBC();
        return instance;
    }
    // 加密
    public String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        byte[] encrypted = encryptByte(sSrc,encodingFormat,sKey,ivParameter);
        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
    }
    // 加密
    public byte[] encryptByte(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        return encrypted;
    }
    // 解密
    public String decrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        byte[] encrypted = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
        return decryptByte(encrypted,encodingFormat,sKey,ivParameter);
    }
    // 解密
    public String decryptByte(byte[] encrypted, String encodingFormat, String sKey, String ivParameter) throws Exception {
        try {
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(encrypted);
            String originalString = new String(original,encodingFormat);
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
        // 需要加密的字串
        String cSrc = "123456";
        System.out.println("加密前的字串是："+cSrc);
        // 加密
        String enString = AesCBC.getInstance().encrypt(cSrc,"UTF-8",sKey,ivParameter);
        System.out.println("加密后的字串是："+ enString);

        System.out.println("1jdzWuniG6UMtoa3T6uNLA==".equals(enString));

        // 解密
        String DeString = AesCBC.getInstance().decrypt(enString,"UTF-8",sKey,ivParameter);
        System.out.println("解密后的字串是：" + DeString);
    }
}