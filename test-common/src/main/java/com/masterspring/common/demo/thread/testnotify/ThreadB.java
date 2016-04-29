package com.masterspring.common.demo.thread.testnotify;

public class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is Running");
			for (int i = 0; i < 100; i++) {
				total += i;
			}
			notify();// 执行完毕，唤醒被暂停的线程
		}
	}
}
