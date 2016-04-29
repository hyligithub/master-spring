package com.masterspring.common.demo.thread.test;

public class YieldTest implements Runnable {

	private String name;

	public YieldTest(String s) {
		this.name = s;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++) {
			System.out.println("name=:" + i);
			if (i % 10 == 0) {
				System.out.println("11221313");
				Thread.yield();
			}
		}

	}

}
