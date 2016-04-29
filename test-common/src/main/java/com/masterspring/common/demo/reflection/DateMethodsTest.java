package com.masterspring.common.demo.reflection;

import java.lang.reflect.Method;

public class DateMethodsTest {
	public static void main(String args[]) throws ClassNotFoundException {
		Class<?> classType = Class.forName("java.util.Date");
		Method methods[] = classType.getDeclaredMethods();
		for (Object o : methods) {
			System.out.println(o.toString());
		}
	}
}
