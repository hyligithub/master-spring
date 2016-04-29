package com.masterspring.common.demo.proxy.staticproxy;

public class ProxySubject extends Subject {

	private RealSubject realSubject;

	@Override
	public void request() {
		// TODO Auto-generated method stub
		preRequest();
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		realSubject.request();
		postRequest();
	}

	private void preRequest() {
		System.out.println("先前做的事");
	}

	private void postRequest() {
		System.out.println("之后做的事");
	}
}
