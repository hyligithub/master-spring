package com.masterspring.common.demo.java7.concurrency.readwritelock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriceInfo pricesInfo = new PriceInfo();

		Thread threadsReader[] = new Thread[2];
		for (int i = 0; i < 2; i++) {
			threadsReader[i] = new Thread(new Reader(pricesInfo));
		}
		 Writer writer = new Writer(pricesInfo);
		 Thread threadWriter = new Thread(writer);

		for (int i = 0; i < 2; i++) {
			threadsReader[i].start();
		}
		 threadWriter.start();

	}

}
