package com.masterspring.common.demo.thread.test;

public class MyRunnable implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread mt = new Thread(new MyRunnable());
		mt.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("invoke myrunnable");
		}
	}

}
