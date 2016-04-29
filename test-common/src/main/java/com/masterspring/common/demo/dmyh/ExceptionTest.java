package com.masterspring.common.demo.dmyh;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new ExceptionTest().devide(2, 0);
		// testException1();
		// testException2();
		// printFile("D:/file");
		try {
			g();
		} catch (ExceptionC e) {
			e.printStackTrace();
		}
	}

	public int devide(int num1, int num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("除数不能为零");
		}
		return num1 / num2;
	}

	public static void testException1() {
		int[] ints = new int[] { 1, 2, 3, 4 };
		System.out.println("异常出现前");
		try {
			System.out.println(ints[4]);
			System.out.println("能执行到吗？");// 发生异常，后续代码不能执行
		} catch (IndexOutOfBoundsException e) {
			System.out.println("数组越界异常");
		}
		System.out.println("异常出现后");
	}

	public static void testException2() {
		int[] ints = new int[] { 1, 2, 3, 4 };
		System.out.println("异常出现前");
		System.out.println(ints[5]);
		System.out.println("我还有幸执行到吗");// 发生异常以后，他后面的代码不能被执行
	}

	public static void readFile(String file) throws FileNotFoundException {
		try {
			BufferedInputStream in = new BufferedInputStream(
					new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err
					.println("不知道如何处理该异常或者根本不想处理它，但是不做处理又不合适，这是重新抛出异常交给上一级处理");
			// 重新抛出异常
			throw e;
		}
	}

	public static void printFile(String file) {
		try {
			readFile(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void f() throws ExceptionB {
		throw new ExceptionB("exception b");
	}

	static void g() throws ExceptionC {
		try {
			f();
		} catch (ExceptionB e) {
			ExceptionC c = new ExceptionC("exception a");
			//异常连  
			c.initCause(e);  
			throw c;
		}
	}

	/*
	 * exception.ExceptionC at exception.NeverCaught.g(NeverCaught.java:12) at
	 * exception.NeverCaught.main(NeverCaught.java:19)
	 */

}
