package com.masterspring.common.demo.example.initialorder;

/**
 * @author lihy
 *
类继承初始化顺序如下：
parent--静态变量
parent--初始化静态模块
sub--静态变量
sub--初始化静态模块
parent--变量
parent--初始化块
parent--初始化构造函数
sub--变量
sub--初始化块
sub--初始化构造函数
 *
 */
public class SubClass extends Parent{
	public static String staticField="sub--静态变量";
	public String field ="sub--变量";
	static{
		System.out.println(staticField);
		System.out.println("sub--初始化静态模块");
	}
	{
		System.out.println(field);
		System.out.println("sub--初始化块");
	}
	public SubClass(){
		System.out.println("sub--初始化构造函数");
	}
	public static void main(String args[]){
		new SubClass();
	}
}
