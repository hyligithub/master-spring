package com.masterspring.common.demo.java7.concurrency.readwritelock;

public class Reader implements Runnable {

	PriceInfo priceinfo;

	public Reader(PriceInfo p) {
		this.priceinfo = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 5; i++) {
			System.out.printf("%s,price1:[%f]\n", Thread.currentThread()
					.getName(), priceinfo.getPrice1());
			System.out.printf("%s,price1:[%f]\n", Thread.currentThread()
					.getName(), priceinfo.getPrice2());
//		}
	}

}
