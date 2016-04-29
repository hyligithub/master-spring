package com.masterspring.common.demo.proxy.example2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CommonInvocationHandler implements InvocationHandler {

	/**
	 * 动态执行对象,需要回调的对象
	 */
	private Object target;

	/**
	 * 支持构造子注射
	 */
	public CommonInvocationHandler() {

	}

	public CommonInvocationHandler(Object target) {
		this.setTarget(target);
	}

	/**
	 * @param target
	 */
	public void setTarget(Object target) {
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(target, args);
	}

}
