package com.masterspring.common.demo.proxy.test.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProxyBookFacade proxy = new ProxyBookFacade();
		BookFacade b = (BookFacade)proxy.bind(new BookFacadeImpl());
		b.addBook();
	}

}
