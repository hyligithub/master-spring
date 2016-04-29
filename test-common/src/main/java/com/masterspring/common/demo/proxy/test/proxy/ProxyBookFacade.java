package com.masterspring.common.demo.proxy.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lihy
 *	Java动态代理类
 */
public class ProxyBookFacade implements InvocationHandler{
	
	private Object target;//委托对象
	
	/**绑定委托对象并返回代理类
	 * @param target
	 * @return
	 */
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		System.out.println("调用之前");
		result = method.invoke(target, args);
		System.out.println("调用之后");
		return result;
	}

}
