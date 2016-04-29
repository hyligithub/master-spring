package com.masterspring.common.demo.pattern.factory.com;


public class ConcreateFactoryA extends AbstractFactory{

	@Override
	public IProduct getIProduct() {
		// TODO Auto-generated method stub
		return new ProductA();
	}

}
