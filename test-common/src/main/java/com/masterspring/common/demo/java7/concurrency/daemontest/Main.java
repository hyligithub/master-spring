package com.masterspring.common.demo.java7.concurrency.daemontest;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Event> deque = new ArrayDeque<Event>();
		WriteTask writeTask = new WriteTask(deque);
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(writeTask);
			thread.start();
		}
		CleanTask cleanTask = new CleanTask(deque);
		cleanTask.start();
	}

}
