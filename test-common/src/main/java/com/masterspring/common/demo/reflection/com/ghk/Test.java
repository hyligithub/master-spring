package com.masterspring.common.demo.reflection.com.ghk;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class<?> classType = Class.forName("reflection.com.ghk.Person");
		Object object = classType.newInstance();
		Field fields[] = classType.getDeclaredFields();
		for (Field f : fields) {
			String fieldName = f.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { String.class });
			if ("name".equals(fieldName)) {
				setMethod.invoke(object, "aaa");
			} else if ("address".equals(fieldName)) {
				setMethod.invoke(object, "bbb");
			}
		}
		System.out.println(object);
	}

}
