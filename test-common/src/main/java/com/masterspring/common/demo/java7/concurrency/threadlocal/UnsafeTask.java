package com.masterspring.common.demo.java7.concurrency.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	private Date startDate;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		startDate = new Date();
		System.out.printf("Starting Thread:%s:%s\n", Thread.currentThread()
				.getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread finished:%s:%s\n", Thread.currentThread()
				.getId(), startDate);
	}

}
