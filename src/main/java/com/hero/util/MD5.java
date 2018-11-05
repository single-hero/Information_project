package com.hero.util;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 * @author chenwenwei
 * @time 2018.11.03
 */
public class MD5 {
	//小写加密
	public static String md5(String str) {
		System.out.println("加密参数"+str);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	
	
	//md5大写加密
	public static String md5Capital(String s){
	char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	         try {
	             byte[] strTemp = s.getBytes();
	             //使用MD5创建MessageDigest对象
	             MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	             mdTemp.update(strTemp);
	             byte[] md = mdTemp.digest();
	             int j = md.length;
	             char str[] = new char[j * 2];
	             int k = 0;
	             for (int i = 0; i < j; i++) {
	                 byte b = md[i];
	                 //System.out.println((int)b);
	                 //将没个数(int)b进行双字节加密
	                 str[k++] = hexDigits[b >> 4 & 0xf];
	                 str[k++] = hexDigits[b & 0xf];
	             }
	             return new String(str);
	         } catch (Exception e) {return null;}
	}
	
	public static void main(String[] args) {

		System.out.println(md5Capital("8255254631132154352265153540237464"));
	}
}
