package com.masterspring.common.demo.java7.concurrency.threadgroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Result result;

	public SearchTask(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s:Start\n", name);
		try {
			doTask();
			result.setName(name);

		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;

		}
		System.out.printf("Thread %s:finish\n", name);
	}

	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(),
				value);
		TimeUnit.SECONDS.sleep(value);

	}
}
