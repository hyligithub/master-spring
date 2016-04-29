package com.masterspring.common.demo.java7.concurrency.threadfactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadFactory tf = new MyThreadFactory("myThreadFactory");
		Task task = new Task();
		Thread thread;
		System.out.println("开始创建线程");
		for (int i = 0; i < 10; i++) {
			thread = tf.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n", tf.getStats());

	}

}
