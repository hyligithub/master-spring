package com.masterspring.common.demo.java7.concurrency.lock;

public class Job implements Runnable {

	private PrintQueue queue;

	public Job(PrintQueue queue) {
		this.queue = queue;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Going to print a document\n", Thread
				.currentThread().getName());
		queue.printQueue(new Object());
		System.out.printf("%s: The document has been printed\n", Thread
				.currentThread().getName());

	}

}
