package com.masterspring.common.demo.pattern.factory.testfactory;

public class FactoryB  extends AbsFactory{

	@Override
	public IProduct getProduct() {
		// TODO Auto-generated method stub
		return new ProductB();
	}

}
