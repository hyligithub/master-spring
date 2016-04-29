package com.masterspring.common.demo.example.encodetest;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;

public class EncodeTest {
	
	/**根据指定字符集打印字符串的字节长度
	 * @param s
	 * @param encodeName
	 */
	public static void printByteLength(String s,String encodeName){
		System.out.println("字节数");
		try {
			System.out.println(s.getBytes(encodeName).length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("字符集:"+encodeName);
	}
	
	public static void main(String[] args){
		String en="A";
		String ch="人";
		
		EncodeTest.printByteLength(en, "GB2312");
		EncodeTest.printByteLength(en, "GBK");
		EncodeTest.printByteLength(en, "UTF-8");
		EncodeTest.printByteLength(en, "UTF-16");
		EncodeTest.printByteLength(en, "ISO-8859-1");
		
		System.out.println("------------");
		
		EncodeTest.printByteLength(ch, "GB2312");
		EncodeTest.printByteLength(ch, "GBK");
		EncodeTest.printByteLength(ch, "UTF-8");
		EncodeTest.printByteLength(ch, "UTF-16");
		EncodeTest.printByteLength(ch, "ISO-8859-1");
		
	}
}
