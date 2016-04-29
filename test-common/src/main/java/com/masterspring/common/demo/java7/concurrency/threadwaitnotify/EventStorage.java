package com.masterspring.common.demo.java7.concurrency.threadwaitnotify;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

	private int maxSize;
	private LinkedList<Date> storage;

	public EventStorage() {
		this.maxSize = 10;
		this.storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		while (maxSize == storage.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		storage.offer(new Date());
		System.out.printf("Set:%d\n", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s\n", storage.size(),
				((LinkedList<Date>) storage).poll());
		notifyAll();
	}
}
