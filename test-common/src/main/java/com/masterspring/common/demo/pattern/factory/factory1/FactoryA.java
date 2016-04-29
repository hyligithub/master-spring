package com.masterspring.common.demo.pattern.factory.factory1;

public class FactoryA extends AbsFactory {
	public FactoryA() {
		super();
	}

	@Override
	public ISuperProduct getIsp() {
		// TODO Auto-generated method stub
		return new ProductA();

	}

}
