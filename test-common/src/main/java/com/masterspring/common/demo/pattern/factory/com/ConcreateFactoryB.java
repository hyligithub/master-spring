package com.masterspring.common.demo.pattern.factory.com;


public class ConcreateFactoryB extends AbstractFactory{

	@Override
	public IProduct getIProduct() {
		// TODO Auto-generated method stub
		return new ProductB();
	}

}
