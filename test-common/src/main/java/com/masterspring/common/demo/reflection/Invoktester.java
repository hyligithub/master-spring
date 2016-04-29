package com.masterspring.common.demo.reflection;

import java.lang.reflect.Method;

public class Invoktester {
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	public String echo(String msg) {
		return msg;
	}

	public static void main(String[] args) throws Exception {
		Class<?> classType = Invoktester.class;
		Object invokTester = (Invoktester) classType.newInstance();
		//
		Method addMethod = classType.getMethod("add", new Class[] {
				Integer.class, Integer.class });
		Object result = addMethod.invoke(invokTester, new Object[] { 10, 10 });
		System.out.println(result);
		Method echoMethod = classType.getMethod("echo",
				new Class[] { String.class });
		Object msg = echoMethod.invoke(invokTester, new Object[] { "hello" });
		System.out.println(msg);
	}
}
