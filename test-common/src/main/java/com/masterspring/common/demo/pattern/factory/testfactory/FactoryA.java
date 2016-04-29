package com.masterspring.common.demo.pattern.factory.testfactory;

public class FactoryA extends AbsFactory{

	@Override
	public IProduct getProduct() {
		// TODO Auto-generated method stub
		return new ProductA();
	}
	
}
