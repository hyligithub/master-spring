package com.masterspring.common.demo.java7.concurrency.threadwaitnotify;

public class Producer implements Runnable {
	EventStorage e = new EventStorage();

	public Producer(EventStorage e) {
		this.e = e;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			e.set();
		}

	}

}
