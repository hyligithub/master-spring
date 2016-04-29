package com.masterspring.common.demo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RealSubject rs = new RealSubject();// 指定被代理类
		InvocationHandler dps = new DynamicProxySubject(rs);
		Class<?> classType = rs.getClass();
		Subject subject = (Subject) Proxy.newProxyInstance(classType
				.getClassLoader(), classType.getInterfaces(), dps);
		subject.request();
	}
}
