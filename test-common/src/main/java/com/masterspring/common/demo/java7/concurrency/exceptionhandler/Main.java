package com.masterspring.common.demo.java7.concurrency.exceptionhandler;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Task());
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
