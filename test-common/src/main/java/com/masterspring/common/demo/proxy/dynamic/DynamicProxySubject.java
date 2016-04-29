package com.masterspring.common.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxySubject implements InvocationHandler {
	private Object obj;

	public DynamicProxySubject() {

	}

	public DynamicProxySubject(Object o) {
		obj = o;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("调用前:" + method);
		method.invoke(obj, args);
		System.out.println("调用后:" + method);
		return null;
	}

}
