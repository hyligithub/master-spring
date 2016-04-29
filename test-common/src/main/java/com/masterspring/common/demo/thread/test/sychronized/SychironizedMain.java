package com.masterspring.common.demo.thread.test.sychronized;

public class SychironizedMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account(10000);
		Thread t1 = new Thread(new BoyThread(account));
		Thread t2 = new Thread(new GirlThread(account));
		t1.start();
		t2.start();
	}

}
