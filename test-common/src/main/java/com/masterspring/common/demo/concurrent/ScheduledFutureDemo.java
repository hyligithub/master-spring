package com.masterspring.common.demo.concurrent;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class ScheduledFutureDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 线程池开辟2个线程
		final ScheduledExecutorService scheduler = Executors
				.newScheduledThreadPool(2);
		// 將軍
		final Runnable general = new Runnable() {
			int count = 0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + ":"
						+ new Date() + "赵云巡视来了 " + (++count));

			}

		};
		// 士兵
		final Runnable soldier = new Runnable() {
			int count = 0;

			public void run() {
				System.out.println(Thread.currentThread().getName() + ":"
						+ new Date() + "士兵巡视来了 " + (++count));
			}
		};

		// 一秒钟后运行，每隔2秒运行一次
		final ScheduledFuture beeperHandle1 = scheduler.scheduleAtFixedRate(
				soldier, 1, 1, SECONDS);
		final ScheduledFuture beeperHandle2 = scheduler.scheduleAtFixedRate(
				general, 5, 5, SECONDS);
		// 30秒后结束关闭任务，并且关闭Scheduler
		scheduler.schedule(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				beeperHandle1.cancel(true);
				beeperHandle2.cancel(true);
				scheduler.shutdown();
			}

		}, 30, SECONDS);
	}

}
