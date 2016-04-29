package com.masterspring.common.demo.example.initialorder;

public class Parent {
	public static String staticField="parent--静态变量";
	public String field ="parent--变量";
	static{
		System.out.println(staticField);
		System.out.println("parent--初始化静态模块");
	}
	{
		System.out.println(field);
		System.out.println("parent--初始化块");
	}
	public Parent(){
		System.out.println("parent--初始化构造函数");
	}
	public static void main(String args[]){
		new Parent();
	}
}
