package com.masterspring.common.demo.java7.concurrency.lockfair;

import java7.concurrency.lock.Job;
import java7.concurrency.lock.PrintQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintQueue queue = new PrintQueue();
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 2; i++) {
			threads[i] = new Thread(new Job(queue));
		}
		for (int i = 0; i < 2; i++) {
			threads[i].start();
		}

	}

}
