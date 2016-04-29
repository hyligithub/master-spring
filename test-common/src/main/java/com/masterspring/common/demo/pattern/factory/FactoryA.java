package com.masterspring.common.demo.pattern.factory;

public class FactoryA implements FactoryInterface {

	public IProduct getIProduct() {
		// TODO Auto-generated method stub
		return new ProductA();
	}

}
