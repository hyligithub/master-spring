package com.masterspring.common.demo.java7.concurrency.daemontest;

import java.util.Date;
import java.util.Deque;

public class CleanTask extends Thread {

	private Deque<Event> deque;

	public CleanTask(Deque<Event> deque) {
		this.deque = deque;
		this.setDaemon(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {
		long difference;
		boolean delete = false;
		if (deque.size() == 0) {
			return;
		}
		do {
			Event e = deque.getLast();
			difference = date.getTime() - e.getAddDate().getTime();

			if (difference > 10000) {
				System.out.printf("cleaner %s\n", e.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while (difference > 10000);
		if (delete) {
			System.out.printf("Cleaner: size of deque: %d\n", deque.size());
		}
	}
}
