package com.masterspring.common.demo.proxy.example2;

import java.lang.reflect.Proxy;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 通用动态代理实现
		CommonInvocationHandler handler = new CommonInvocationHandler();
		Foo f;

		// 接口实现
		handler.setTarget(new FooImpl());
		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				new Class[] { Foo.class }, handler);
		f.doAction();

		handler.setTarget(new FooImpl2());
		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				new Class[] { Foo.class }, handler);
		f.doAction();
	}

}
