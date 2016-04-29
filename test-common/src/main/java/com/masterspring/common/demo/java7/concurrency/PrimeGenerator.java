package com.masterspring.common.demo.java7.concurrency;

public class PrimeGenerator extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new PrimeGenerator();
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number  %d is Prime\n",number);
			}
			if (isInterrupted()) {
				return;
			}
			number++;
		}

	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if (number % 2 == 0)
				return false;
		}
		return true;
	}

}
