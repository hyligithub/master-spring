package com.masterspring.common.demo.thread.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepTest implements Runnable {

	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-mm-dd hh:mm:ss");

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("child thread begin");
		int i = 0;
		while (++i < 5) {
			System.out.println(format.format(new Date()));
		}
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("child thread dead at:" + format.format(new Date()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new SleepTest());
		t.start();
		try {
			Thread.sleep(20000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t.interrupt();
		System.out.println("main method dead");
	}
}
