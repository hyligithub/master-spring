package com.masterspring.common.demo.thread.jd;

import java.util.LinkedList;
import java.util.List;

public class TestThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPool t = ThreadPool.getThreadPool(3);
		List<Runnable> taskQueue = new LinkedList<Runnable>();
		taskQueue.add(new Task());
		taskQueue.add(new Task());
		taskQueue.add(new Task());
		t.execute(taskQueue);
		System.out.println(t);
		t.destory();
		System.out.println(t);
	}

	static class Task implements Runnable {
		private static volatile int i = 1;

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("任务 " + (i++) + " 完成");
		}

	}

}
