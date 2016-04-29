package com.masterspring.common.demo.reflection.com.ghk;

public class Test2 {
	public static void main(String[] args) throws Exception {
		Class<?> classType = Class.forName("reflection.com.ghk.Person1");
		Object obj = classType.getConstructor(
				new Class[] { String.class, String.class }).newInstance(
				new Object[] { "aaa", "bbb" });
		System.out.println(obj);
	}
}
