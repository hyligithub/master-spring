package com.masterspring.common.demo.pattern.factory.com;


public class FactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory a=new ConcreateFactoryA();
		a.newProduct();
	}

}
