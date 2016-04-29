package com.masterspring.common.demo.dmyh;

import java.util.HashMap;
import java.util.Map;

public class StringConcatenation {
	// 无参数使用String+拼接字符串
	public String getString() {
		String result = "SELECT ID,NAME,CARDID, AGE" + "FROM USERINFO "
				+ "WHERE NAME LIKE '%苏%' " + "AND AGE > 25 "
				+ "ORDER BY AGE ASC";
		return result;
	}

	// 带参数使用String+拼接字符串
	public String getString(String name, int age) {
		String result = "SELECT ID,NAME,CARDID, TRUNC(BORNEDDATE)"
				+ "FROM USERINFO " + "WHERE NAME LIKE '%" + name + "%' "
				+ "AND AGE > " + age + " ORDER BY AGE ASC";
		return result;
	}

	// 在循环中使用String+拼接字符串
	public String implicit() {
		String result = "";
		for (int i = 0; i < 1000; i++) {
			result += "SELECT";
		}
		return result;
	}

	// 在循环中使用StringBuilder拼接字符串
	public String explicit() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			result.append("SELECT");
		}
		return result.toString();
	}

	public String explicit1(){
		StringBuffer result = new StringBuffer();
		for(int i = 0;i < 10000; i++){
			result.append("SELECT");
		}
		return result.toString();
	}
	// 各方法运行时间
	public static void main(String[] args) {
		StringConcatenation sc = new StringConcatenation();
		long time1 = 0L, time2 = 0L;
		Map<String, Object> map = new HashMap<String, Object>();

		System.out.println("无参数使用String+拼接字符串...");
		time1 = System.currentTimeMillis();
		map.put("string1", sc.getString());
		time2 = System.currentTimeMillis();
		System.out.println("运行时间：" + (time2 - time1) + " ms\n\n");

		System.out.println("带参数使用String+拼接字符串...");
		time1 = System.currentTimeMillis();
		map.put("string2", sc.getString("苏", 25));
		time2 = System.currentTimeMillis();
		System.out.println("运行时间：" + (time2 - time1) + " ms\n\n");

		System.out.println("在循环中使用String+拼接字符串...");
		time1 = System.currentTimeMillis();
		map.put("string3", sc.implicit());
		time2 = System.currentTimeMillis();
		System.out.println("运行时间：" + (time2 - time1) + " ms\n\n");

		System.out.println("在循环中使用StringBuilder拼接字符串...");
		time1 = System.currentTimeMillis();
		map.put("string4", sc.explicit());
		time2 = System.currentTimeMillis();
		System.out.println("运行时间：" + (time2 - time1) + " ms");
		
		System.out.println("在循环中使用StringBuffer拼接字符串...");
		time1 = System.currentTimeMillis();
		map.put("string5", sc.explicit1());
		time2 = System.currentTimeMillis();
		System.out.println("运行时间：" + (time2 - time1) + " ms");
	}
}
