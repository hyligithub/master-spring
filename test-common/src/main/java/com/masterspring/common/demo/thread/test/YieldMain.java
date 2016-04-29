package com.masterspring.common.demo.thread.test;

public class YieldMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r1 = new YieldTest("S1");
		Runnable r2 = new YieldTest("S2");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main method over!");
	}

}
