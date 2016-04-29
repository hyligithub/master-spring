package com.masterspring.common.demo.java7.concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepTest implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = new Thread(new SleepTest());
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();

	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				System.out.printf("The FileClock has been interrupted");
			}
		}
	}

}
