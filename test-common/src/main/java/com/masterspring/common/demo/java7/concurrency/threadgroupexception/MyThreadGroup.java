package com.masterspring.common.demo.java7.concurrency.threadgroupexception;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has throw Exception\n", t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of thread\n");
		this.interrupt();
	}

}
