package com.masterspring.common.demo.pattern.factory.factory1;

public class FactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long userId = null;
		AbsFactory af = new FactoryA();
		af.delInfo(userId);
		af.save(userId);
		af.save(userId);
	}

}
