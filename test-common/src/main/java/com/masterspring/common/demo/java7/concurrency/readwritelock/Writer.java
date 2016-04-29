package com.masterspring.common.demo.java7.concurrency.readwritelock;

import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {

	PriceInfo p;

	public Writer(PriceInfo p) {
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		for (int i = 0; i < 3; i++) {
			System.out.println("Wtiter:attempt to modify price");
			p.setPrice(Math.random() * 10, Math.random() * 8);
			System.out.println("Wtiter: modify price end");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//		}
	}

}
