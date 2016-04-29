package com.masterspring.common.demo.example.initialorder;

public class TestOrder {

	public static ClassA a = new ClassA();
	static{
		System.out.println("静态初始化块");
	}
	public static ClassB b = new ClassB();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestOrder();
	}

}
