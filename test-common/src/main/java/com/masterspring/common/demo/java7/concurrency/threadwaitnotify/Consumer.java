package com.masterspring.common.demo.java7.concurrency.threadwaitnotify;

public class Consumer implements Runnable {

	EventStorage e = new EventStorage();

	public Consumer(EventStorage e) {
		this.e = e;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			e.get();
		}

	}

}
