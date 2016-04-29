package com.masterspring.common.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester {
	public Object copy(Object object) throws Exception {
		// 获得对象的类型
		Class<?> classType = object.getClass();
		System.out.println("Class:" + classType.getName());
		// 通过默认构造方法创建一个新的对象
		Object copyObject = classType.getConstructor(new Class[] {})
				.newInstance(new Object[] {});
		// 获得对象的所有属性
		Field fields[] = classType.getDeclaredFields();
		for (Field o : fields) {
			String fieldName = o.getName();

			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			// 获得和属性对应的getXXX(),setXXX()方法的名称
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			// 获得和属性对应的getXXX()
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { o.getType() });
			// 调用原对象的get方法
			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + ":" + value);
			// 调用拷贝对象的setXXX()方法
			setMethod.invoke(copyObject, new Object[] { value });
		}
		return copyObject;
	}
}
