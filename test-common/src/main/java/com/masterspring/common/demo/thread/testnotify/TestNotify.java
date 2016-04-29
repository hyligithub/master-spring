package com.masterspring.common.demo.thread.testnotify;

public class TestNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNotify t = new TestNotify();
		ThreadB b = new ThreadB();
		System.out.println("b is start");
		b.start();
		synchronized (b) {
			try {
				System.out.println("wait for b to complete");
				b.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println("Final Total is:" + b.total);

		}
	}

}
