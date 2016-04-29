package com.masterspring.common.demo.thread.test.test;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

	private static int thread_num = 5;// 线程池内线程数
	private static WorkThread[] workThreads;// 工作线程数组
	private static ThreadPool threadPool;
	private static List<Runnable> taskQueue = new LinkedList<Runnable>();// 任务队列

	// 创建默认线程池，包含5个线程
	private ThreadPool() {
		this(thread_num);
	}

	// 创建指定个数线程的线程池
	public ThreadPool(int thread_num) {
		ThreadPool.thread_num = thread_num;
		workThreads = new WorkThread[thread_num];
		for (int i = 0; i < thread_num; i++) {
			workThreads[i] = new WorkThread();
			workThreads[i].start();
		}
	}

	// 单态，获得默认线程池，5个线程
	public static ThreadPool getThreadPool() {
		return new ThreadPool(thread_num);

	}

	// 单态，获得指定线程个数的线程池
	public static ThreadPool getTheadPool(int thread_num1) {
		if (thread_num1 <= 0) {
			thread_num1 = thread_num;
		}
		if (threadPool == null) {
			threadPool = new ThreadPool(thread_num1);
		}
		return threadPool;
	}

	// 工作线程执行任务
	public void execute(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notifyAll();
		}
	}

	// 批量执行任务
	public void execute(List<Runnable> task) {
		synchronized (taskQueue) {
			for (Runnable r : task) {
				taskQueue.add(r);
			}
			taskQueue.notifyAll();
		}
	}

	public void destroy() {
		while (!taskQueue.isEmpty()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < workThreads.length; i++) {
			workThreads[i].stopWorkThread();
			workThreads[i] = null;
		}
		threadPool = null;
		taskQueue.clear();
	}

	static class WorkThread extends Thread {
		private boolean isRunning = true;

		public void run() {
			Runnable r = null;
			while (isRunning) {// 工作线程处于可运行状态
				synchronized (taskQueue) {
					while (isRunning && taskQueue.isEmpty()) {// 如果队列为空，等待
						try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (!taskQueue.isEmpty()) {
						r = taskQueue.remove(0);
					}
					if (r != null) {
						r.run();// 执行任务
					}
					r = null;
				}
			}
		}

		private void stopWorkThread() {
			this.isRunning = false;
		}
	}
}
