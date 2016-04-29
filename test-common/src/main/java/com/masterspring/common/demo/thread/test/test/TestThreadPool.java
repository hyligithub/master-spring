package com.masterspring.common.demo.thread.test.test;

import java.util.LinkedList;
import java.util.List;

public class TestThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPool tp = ThreadPool.getTheadPool(7);
		List<Runnable> taskQueue = new LinkedList<Runnable>();
		for(int i=0;i<3;i++){
			taskQueue.add(new Task());
		}
		tp.execute(taskQueue);
		tp.destroy();

	}

	static class Task implements Runnable {
		private static volatile int i = 1;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("任务" + (i++) + "完成");
		}

	}

}
