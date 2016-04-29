package com.masterspring.common.demo.pattern.factory.testfactory;

public abstract class AbsFactory {

	private IProduct ip;

	public AbsFactory() {
	}

	public abstract IProduct getProduct();

	public void newProduct() {
		ip = getProduct();
		ip.doSom();
	}

}
