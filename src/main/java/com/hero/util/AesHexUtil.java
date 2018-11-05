package com.hero.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Aes加密hex编码工具类
 * @author chenwenwei
 * @time 2018.11.03
 */
public class AesHexUtil {
	private static final String KEY = "30b2b701096549fd";	//加密key
	private static final String KEY_iv = "b12af5a112a54103";	//加密偏移量
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";//默认的加密算法

    
    public static String aesEncode(String str){
    	String hexencode="";
		try{ 
			//将key进行byte转换,如果是byte就不用换砖
			byte[] keyBytes = KEY.getBytes();
			SecretKeySpec skey = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
			//默认加密算法
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE,skey,new IvParameterSpec(KEY_iv.getBytes()));
            //开始进行aes加密
            byte[] result = cipher.doFinal(str.getBytes());
            //进行hex转换
            hexencode=HexUtil.encode(result);           
        }catch (Exception e) {  
            System.out.println("exception:"+e.toString());  
        } 
    	return hexencode;
    }
    
    //测试
	public static void main(String[] args){
		String str="singlehero";
		String key="30b2b701096549fd";//加密key
		String key_iv="b12af5a112a54103";//加密偏移量
		try{ 
			//将key进行byte转换,如果是byte就不用换砖
			byte[] keyBytes = key.getBytes();
			SecretKeySpec skey = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
			//默认加密算法
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE,skey,new IvParameterSpec(key_iv.getBytes()));
            //开始进行aes加密
            byte[] result = cipher.doFinal(str.getBytes());
            //进行hex转换
            HexUtil.encode(result);
            System.out.println(HexUtil.encode(result));
            
        }catch (Exception e) {  
            System.out.println("exception:"+e.toString());  
        }   
	}
	
}
