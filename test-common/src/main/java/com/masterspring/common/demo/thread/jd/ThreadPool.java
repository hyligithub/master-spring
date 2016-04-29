package com.masterspring.common.demo.thread.jd;

import java.util.LinkedList;
import java.util.List;

public final class ThreadPool {

	private static int worker_num = 5;// 线程池中默认线程的个数
	private WorkThread[] workThreads;// 工作线程
	private static volatile int finished_task = 0;//
	private List<Runnable> taskQueue = new LinkedList<Runnable>();// 任务队列，作为缓冲

	private static ThreadPool threadPool;

	// 创建具有默认个数的线程池
	public ThreadPool() {
		this(5);
	}

	// 创建线程池，worker_num为线程池中工作线程的个数
	private ThreadPool(int worker_num) {
		ThreadPool.worker_num = worker_num;// 1.初始化线程个数
		workThreads = new WorkThread[worker_num];// 2.初始化工作线程数组
		// 3.工作线程开始工作
		for (int i = 0; i < workThreads.length; i++) {
			workThreads[i] = new WorkThread();
			workThreads[i].start();
		}
	}

	// 单态，获得默认线程个数的线程池
	public static ThreadPool getThreadPool() {
		return ThreadPool.getThreadPool(ThreadPool.worker_num);
	}

	// 单态，获得指定线程个数的线程池，如果worker_nu1<=0,初始化为默认线程个数
	public static ThreadPool getThreadPool(int worker_num1) {
		if (worker_num1 <= 0) {
			worker_num1 = ThreadPool.worker_num;
		}
		if (threadPool == null) {
			threadPool = new ThreadPool(worker_num1);
		}
		return threadPool;
	}

	// 执行任务，把任务放入队列，具体执行由线程池负责
	public void execute(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notify();
		}
	}

	public void execute(List<Runnable> task) {
		synchronized (taskQueue) {
			for (Runnable r : task)
				taskQueue.add(r);
			taskQueue.notify();
		}
	}

	public void destory() {
		while (!taskQueue.isEmpty()) {// 等待队列中的任务都执行完，再销毁
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (int i = 0; i < worker_num; i++) {
			workThreads[i].stopWoker();
			workThreads[i] = null;
		}
		threadPool = null;
		taskQueue.clear();
	}

	// 返回工作线程个数
	public int getWaitTasknumber() {
		return this.worker_num;
	}

	// 返回任务队列的长度，既是还没有完成的任务个数
	public int getTaskQueueSize() {
		return this.taskQueue.size();
	}

	// 已完成的任务的个数
	public int getFinishedTaskNumber() {
		return this.finished_task;
	}
	
	public String toString(){
		return "WorkThread number:" + worker_num + "  finished task number:"  
                + finished_task + "  wait task number:" + getWaitTasknumber();  
	}

	public class WorkThread extends Thread {

		private boolean isRunning = true;// 该工作线程是否有效，用于结束该线程

		@Override
		public void run() {

			Runnable r = null;
			while (isRunning) {
				synchronized (taskQueue) {
					while (!isRunning && taskQueue.isEmpty()) {
						try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(!taskQueue.isEmpty()){
						r = taskQueue.remove(0);
					}
				}
				if(r!=null){
					r.run();
				}
				System.out.println(finished_task++);
			
				r=null;
			}
		}

		public void stopWoker() {
			this.isRunning = false;
		}
	}
}
