package com.masterspring.common.demo.tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ss();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	private static void ss() {
		
		List<Student> list1 = new ArrayList<Student>();
		List<Student> list2 = new ArrayList<Student>();
		for(int i=4;i<6;i++){
//			list1.add(new Student(i,"name"+i));
		}
		for(int i=0;i<3;i++){
			list2.add(new Student(i,"name"+i));
		}
		list1.addAll(list2);
		for(Student s:list1){
			System.out.println(s.getId());
		}
	}

	/**
	 * 如果线程在等待invokeAll()执行完成的时候,被中断,会抛出InterruptedException<br>
	 * 此时线程池会终止没有完成的任务,这主要是为了减少资源的浪费.
	 */
	public static void testInvokeAllWhenInterrupt() throws Exception {
		final ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 调用invokeAll的线程
		Thread invokeAllThread = new Thread() {

			@Override
			public void run() {
				List<Callable<String>> tasks = new ArrayList<Callable<String>>();
				tasks.add(new SleepSecondsCallable("t1", 2));
				tasks.add(new SleepSecondsCallable("t2", 2));
				tasks.add(new RandomTenCharsTask());

				// 调用线程会阻塞,直到tasks全部执行完成(正常完成/异常退出)
				try {
					List<Future<String>> results = executorService
							.invokeAll(tasks);
					System.out.println("wait for the result." + results.size());
				} catch (InterruptedException e) {
					System.out
							.println("I was wait,but my thread was interrupted.");
					e.printStackTrace();
				}

			}
		};

		invokeAllThread.start();

		Thread.sleep(200);

		invokeAllThread.interrupt();

		executorService.shutdown();

	}

	/**
	 * 可以通过Future.isCanceled()判断任务是被取消,还是完成(正常/异常)<br>
	 * Future.isDone()总是返回true,对于invokeAll()的调用者来说,没有啥用
	 */
	public static void testInvokeAllTimeout() throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		tasks.add(new SleepSecondsCallable("t1", 0));
		// tasks.add(new RandomTenCharsTask());
		tasks.add(new SleepSecondsCallable("t2", 2));
		// tasks.add(new SleepSecondsCallable("t3", 3));

		List<Future<String>> results = executorService.invokeAll(tasks, 1,
				TimeUnit.SECONDS);

		System.out.println("wait for the result." + results.size());
		for (Future<String> f : results) {
			if (!f.isCancelled()) {
				System.out.println("isCanceled=" + f.isCancelled() + ",isDone="
						+ f.isDone() + f.get());
			} else
				System.out.println("isCanceled=" + f.isCancelled() + ",isDone="
						+ f.isDone());
		}

		// executorService.shutdown();

	}

	public static void testInvokeAll() throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<Callable<String>> tasks = new ArrayList<Callable<String>>();
		tasks.add(new ExceptionCallable());
		tasks.add(new SleepSecondsCallable("t1", 2));
		tasks.add(new SleepSecondsCallable("t2", 2));
		tasks.add(new RandomTenCharsTask());

		// 调用该方法的线程会阻塞,直到tasks全部执行完成(正常完成/异常退出)
		List<Future<String>> results = executorService.invokeAll(tasks);

		// 任务列表中所有任务执行完毕,才能执行该语句
		System.out.println("wait for the result." + results.size());

		executorService.shutdown();

		for (Future<String> f : results) {
			// isCanceled=false,isDone=true
			System.out.println("isCanceled=" + f.isCancelled() + ",isDone="
					+ f.isDone());

			// ExceptionCallable任务会报ExecutionException
			System.out.println("task result=" + f.get());
		}
	}
}
