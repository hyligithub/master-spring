package com.masterspring.common.demo.java7.concurrency.threadgroupexception;

import java.util.Random;

public class Task implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while (true) {
			result = 1000 / (int) (random.nextDouble() * 1000);
			System.out.printf("%s : %f\n", Thread.currentThread().getId(),
					result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread()
						.getId());
				return;
			}

		}
	}

}
