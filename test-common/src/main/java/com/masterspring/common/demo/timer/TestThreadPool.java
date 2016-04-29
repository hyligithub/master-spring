package com.masterspring.common.demo.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	private static int produceTaskSleepTime = 2000;

	public static void main(String[] args) {
		// 构造一个线程池
		int threadCount = 2;
		int coreSize = 2;
		int queueSize = 5;
		ThreadPoolExecutor producerPool = new ThreadPoolExecutor(threadCount,
				coreSize, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSize),
				new ThreadPoolExecutor.DiscardOldestPolicy());
		List tasks = new ArrayList();
		// 每隔produceTaskSleepTime的时间向线程池派送一个任务。
		while (true) {
			try {
//				TimeUnit.SECONDS.sleep(5);
				for (int i = 0; i < 3; i++) {
					int exeThreadCount = 0;
					CountDownLatch end = new CountDownLatch(threadCount);
					for (int j = 0; j < threadCount; j++) {
						tasks = getTask();
						producerPool.execute(new ThreadPoolTask(tasks, end,"第"+i+"轮"));
						exeThreadCount++;
					}
					if (exeThreadCount == threadCount) {
						System.out.println("waiting......");
						end.await();
					} else {
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static List getTask() {
		List tasks = new ArrayList();
		for (int i = 0; i < 5; i++) {
			String task = "task@ " + i;
			tasks.add(task);
		}
		return tasks;
	}

}