package com.masterspring.common.demo.java7.concurrency.synchronize;

public class Bank implements Runnable {
	Account account;

	public Bank(Account a) {
		this.account = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			account.subAmount(1000);
		}
	}

}
