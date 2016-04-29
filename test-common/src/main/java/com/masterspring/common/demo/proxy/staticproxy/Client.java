package com.masterspring.common.demo.proxy.staticproxy;

public class Client {
	public static void main(String[] args) {
		Subject proxySubject = new ProxySubject();
		proxySubject.request();
	}
}
