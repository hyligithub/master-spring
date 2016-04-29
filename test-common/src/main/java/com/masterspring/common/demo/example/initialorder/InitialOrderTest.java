package com.masterspring.common.demo.example.initialorder;

/**
 * @author lihy
 * 类初始化顺序如下：
 静态变量
初始化静态模块
变量
初始化块
初始化构造函数

 *
 */
public class InitialOrderTest {
	public static String staticField ="静态变量";
	public String field ="变量";
	static {
		System.out.println(staticField);
		System.out.println("初始化静态模块");
	}
	{
		System.out.println(field);
		System.out.println("初始化块");
	}
	public InitialOrderTest(){
		System.out.println("初始化构造函数");
	}
	public static void main(String args[]){
		new InitialOrderTest();
	}
	
}
