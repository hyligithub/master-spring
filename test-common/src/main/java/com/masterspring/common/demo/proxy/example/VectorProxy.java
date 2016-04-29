package com.masterspring.common.demo.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler {
	private Object obj;

	public VectorProxy(Object o) {
		this.obj = o;
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> v = (List<String>) factory(new Vector<String>(10));
		v.add("New");
		v.add("York");
		System.out.println(v);
		v.remove(0);
		System.out.println(v);
	}

	public static Object factory(Object obj) {
		Class<?> classType = obj.getClass();
		Object o = Proxy.newProxyInstance(classType.getClassLoader(), classType
				.getInterfaces(), new VectorProxy(obj));
		return o;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before calling" + method);
		if (args != null) {
			for (Object o : args) {
				System.out.println(o);
			}
		}
		Object object = method.invoke(obj, args);
		System.out.println("after calling" + method);
		return object;
	}

}
