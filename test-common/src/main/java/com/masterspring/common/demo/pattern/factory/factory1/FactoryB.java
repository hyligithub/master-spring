package com.masterspring.common.demo.pattern.factory.factory1;

public class FactoryB extends AbsFactory {
	public FactoryB() {
		super();
	}

	@Override
	public ISuperProduct getIsp() {
		// TODO Auto-generated method stub
		return new ProductB();
	}

}
