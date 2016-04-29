package com.masterspring.common.demo.pattern.factory;

public class FactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryInterface fa = new FactoryA();
		FactoryInterface fb = new FactoryB();
		fa.getIProduct().doSomething();
		fb.getIProduct().doSomething();
	}

}
