package com.masterspring.common.demo.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubConcurrentHashMap implements Runnable {


	final static int ThreadSIZE = 2500;
	final static int elSize = 500;
	int threadNum;

	public PubConcurrentHashMap(int index) {
		// TODO Auto-generated constructor stub
		this.threadNum = index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 启用线程池
		ExecutorService exec = Executors.newFixedThreadPool(ThreadSIZE);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < ThreadSIZE; i++) {
			exec.execute(new PubHashMap(i));
		}
		long endTime = System.currentTimeMillis();
		exec.shutdown();
//		System.out.println("消耗时间：" + (endTime - startTime) + "ms");
	}

	public void run() {
		// TODO Auto-generated method stub
		Map<String, String> hashMap = new ConcurrentHashMap<String, String>();
		for (int i = 0; i < this.elSize; i++) {
			hashMap.put(i + "" + threadNum, i + "" + threadNum);
		}
	}


}
