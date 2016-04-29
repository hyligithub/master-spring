package com.masterspring.common.demo.proxy.test.cglibproxy;

public class CglibProxyTest {
	public static void main(String[] args){
		CglibProxyBookFacade cglibProxy = new CglibProxyBookFacade();
//		BookFacadeCglibImpl b = (BookFacadeCglibImpl)cglibProxy.getInstance(new BookFacadeCglibImpl());
//		b.addBook();
	}
}
