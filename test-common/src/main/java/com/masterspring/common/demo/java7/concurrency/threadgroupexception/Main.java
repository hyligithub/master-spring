package com.masterspring.common.demo.java7.concurrency.threadgroupexception;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadGroup threadGroup = new MyThreadGroup("myThreadGroup");
		Task task = new Task();
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(threadGroup, task);
			t.start();
		}
	}

}
