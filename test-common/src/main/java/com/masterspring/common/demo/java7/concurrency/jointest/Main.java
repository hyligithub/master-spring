package com.masterspring.common.demo.java7.concurrency.jointest;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1 = new Thread(new DataSourceLoader());
		Thread thread2 = new Thread(new NetWorkConnectionLoader());
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Configuration has been loaded: %s\n",
				new Date());
	}

}
