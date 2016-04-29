package com.masterspring.common.demo.pattern.factory.com;

public abstract class AbstractFactory {
	IProduct ip;

	public abstract IProduct getIProduct();

	public AbstractFactory() {

	}

	public void newProduct() {
		ip = getIProduct();
		ip.doSomething();
	}
}
