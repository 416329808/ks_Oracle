package com.oracle.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class md5 {

	public md5() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 对密码进行加密md5和base64编码
	 * 
	 * @param pwd
	 * @return
	 */
	public static String md5andbase64(String pwd){
		byte[] pwdb=getDigest(pwd.getBytes());	
		BASE64Encoder encoder = new BASE64Encoder();
		pwd=encoder.encode(pwdb);
		return pwd;
	}
			
		/*
		 * MD5加密
		 */
		public static byte[] getDigest(byte[] b){
		try {
				MessageDigest md=MessageDigest.getInstance("MD5");			
				md.update(b);
				return md.digest();
			} catch (NoSuchAlgorithmException e) {
				//FIXME:DDD
				e.printStackTrace();
			}
				
			return null;
		}
		
//		public static void main(String []args){
//			String string=md5andbase64("123456");
//			System.out.println(string);
//		}

}
