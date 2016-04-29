package com.masterspring.common.demo.java7.concurrency.daemontest;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriteTask implements Runnable {

	private Deque<Event> deque;

	public WriteTask(Deque<Event> deque) {
		this.deque = deque;
	}

	public static void main(String[] args) {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 100; i++) {
			Event e = new Event();
			e.setAddDate(new Date());
			e.setEvent(String.format("the thread %s has generate an event\n",
					Thread.currentThread().getId()));
			deque.addFirst(e);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}

}
