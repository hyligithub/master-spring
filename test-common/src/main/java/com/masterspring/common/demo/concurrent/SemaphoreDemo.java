package com.masterspring.common.demo.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author lihy
 *使用Semaphore，限制可以执行的线程数，空闲资源放到队列中等待
 */
public class SemaphoreDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable limitCall = new Runnable() {

			final Random ran = new Random();
			/**
			 * 限制只有5个资源是活动的,第二个参数为true则是按照标准“队列”结构先进先出
			 */
			final Semaphore available = new Semaphore(5, true);
			int count = 0;


			public void run() {
				// TODO Auto-generated method stub
				int time = ran.nextInt(10);
				int needTime = time * 2000;
				int num = count++;
				try {
					available.acquire();// 首先申請資源
					System.out.println("乘客" + num + "买票需要" + needTime + "秒");
					Thread.sleep(needTime);
					System.out.println("乘客" + num + "买完票了");
					available.release();// 释放资源
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		for(int i =0;i<25;i++){
			new Thread(limitCall).start();
		}
	}

}
