package com.masterspring.common.demo.java7.concurrency.threadwaitnotify;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventStorage e = new EventStorage();
		new Thread(new Producer(e)).start();
		new Thread(new Consumer(e)).start();
	}

}
