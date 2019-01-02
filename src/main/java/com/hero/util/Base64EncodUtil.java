package com.hero.util;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Base64编码转换
 * @author chenwenwei
 * @time 2018.11.03
 */
public class Base64EncodUtil {
	 private static final String ENCODING = "UTF-8";
	      
	      /**
	       * 一般Base64加密
	       */
	      public static String encode(String data) throws UnsupportedEncodingException{
	          byte[] encodedByte = Base64.encodeBase64(data.getBytes(ENCODING));
	          return new String(encodedByte, ENCODING);
	      }
	      
	      /**
	       * 安全Base64加密
	       */
	      public static String encodeSafe(String data) throws UnsupportedEncodingException{
	          /*
	           * 注意：这里采用的encodeBase64(byte[] bytes, boolean arg1)
	           * arg1为true时，加密后的字符串每行为76个字符，不论每行够不够76个字符，都要在行尾添加“\r\n”
	           */
	          byte[] encodedByte = Base64.encodeBase64(data.getBytes(ENCODING),true);
	          return new String(encodedByte, ENCODING);
	      }
	      
	      /**
	       * Base64解密
	       */
	      public static String decode(String data) throws UnsupportedEncodingException{
	          byte[] decodedByte = Base64.decodeBase64(data.getBytes(ENCODING));
	          return new String(decodedByte, ENCODING);
	      }
	      
	      //alia加密
	      public static String safeUrlBase64Encode(byte[] data){ 
	    	  String encodeBase64 = new BASE64Encoder().encode(data); 
	    	  String safeBase64Str = encodeBase64.replace('+', '-'); 
	    	  safeBase64Str = safeBase64Str.replace('/', '_'); 
	    	  safeBase64Str = safeBase64Str.replaceAll("=", ""); 
	    	  return safeBase64Str; 
	    } 
	      //解密
	    public static byte[] safeUrlBase64Decode(final String safeBase64Str) throws IOException{ 
	    	  String base64Str = safeBase64Str.replace('-', '+'); 
	    	  base64Str = base64Str.replace('_', '/'); 
	    	  int mod4 = base64Str.length()%4; 
	    	  if(mod4 > 0){ 
	    	  base64Str = base64Str + "====".substring(mod4); 
	    	  } 
	    	  return new BASE64Decoder().decodeBuffer(base64Str); 
	    }

	    public static void main(String[] args){
	      	String a ="123zhon中";
			try {
				System.out.println("加密===.."+safeUrlBase64Encode(a.getBytes()));
				System.out.println("解密---.."+ new String(safeUrlBase64Decode(safeUrlBase64Encode(a.getBytes())),"UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
} 

