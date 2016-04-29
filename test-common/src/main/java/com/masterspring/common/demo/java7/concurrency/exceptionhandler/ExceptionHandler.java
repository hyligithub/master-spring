package com.masterspring.common.demo.java7.concurrency.exceptionhandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", e.getClass().getName(),
				e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}

}
