package com.masterspring.common.demo.thread.test;

public class MyThread extends Thread{
	
	@Override
	public void run(){
		while(true){
			System.out.println("invoke mythread ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		mt.start();
	}

}
