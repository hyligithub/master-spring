package com.masterspring.common.demo.java7.concurrency.jointest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetWorkConnectionLoader implements Runnable {
	public static void main(String[] args) {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("NetWorkConnectionLoader loading,%s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("NetWorkConnectionLoader loading finish,%s\n", new Date());
	}

}
