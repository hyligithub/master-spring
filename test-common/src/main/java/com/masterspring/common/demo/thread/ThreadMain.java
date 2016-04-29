package com.masterspring.common.demo.thread;

public class ThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new ThreadTest();
		t.start();
		
		Thread tt = new Thread(new RunnableTest());
		tt.start();
	}

}
