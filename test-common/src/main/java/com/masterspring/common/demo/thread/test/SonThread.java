package com.masterspring.common.demo.thread.test;

public class SonThread implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("儿子出去买烟需要10分钟");
		try {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(1000);
				System.out.println("儿子出去第" + i + "分钟");

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("儿子买煙回来了");

	}

}
