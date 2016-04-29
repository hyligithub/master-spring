package com.masterspring.common.demo.pattern.callback;

public class Foo {
	private ICallBack icallBack;

	public void setICallBack(ICallBack callback) {
		this.icallBack = callback;
	}
	public void fooRequest(){
		icallBack.request();
	}
}
