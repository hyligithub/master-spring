package com.masterspring.common.demo.reflection;

import java.lang.reflect.Array;

public class ArrayTester {
	public static void main(String[] args) throws Exception {
		Class<?> classType = Class.forName("java.lang.String");
		Object array = Array.newInstance(classType, 10);
		Array.set(array, 5, "hello");
		Object o = Array.get(array, 5);
		System.out.println(o.toString());
	}
}
