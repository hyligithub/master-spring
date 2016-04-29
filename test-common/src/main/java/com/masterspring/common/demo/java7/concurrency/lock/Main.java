package com.masterspring.common.demo.java7.concurrency.lock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintQueue queue = new PrintQueue();
		Thread thread[] = new Thread[10];
		// for (int i = 0; i < 2; i++) {
		// threads[i] = new Thread(new Job(queue));
		// }
		// for (int i = 0; i < 2; i++) {
		// threads[i].start();
		// }

		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(queue), "Thread " + i);
		}
		for (int i = 0; i < 10; i++) {
			thread[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
