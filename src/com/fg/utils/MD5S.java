package com.fg.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;



public class MD5S {

	public static String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * 加密数据
	 * @param org
	 * @return
	 */
	public static String  getMD5Result(String org){
		Md5(org);
		return result;
	}
	

	public static void Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
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

			// System.out.println("result: " + buf.toString());// 32位的加密

			// System.out.println("result: " + buf.toString().substring(8,
			// 24));// 16位的加密

			result = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test(){
		//5058f1af8388633f609cadb75a75dc9d
		System.out.println(getMD5Result("."));
	}

}
