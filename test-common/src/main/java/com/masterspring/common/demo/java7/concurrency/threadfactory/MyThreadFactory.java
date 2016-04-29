package com.masterspring.common.demo.java7.concurrency.threadfactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	private String name;
	private int counter;
	private List<String> stats;

	public MyThreadFactory(String name) {
		this.name = name;
		counter = 0;
		stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r, name + "-Thread-" + counter++);
		stats.add(String.format("created thread %d with name %s on %s\n",
				t.getId(), t.getName(), new Date()));
		return t;
	}

	public String getStats() {
		StringBuffer sb = new StringBuffer();
		for (String s : stats) {
			sb.append(s).append("\n");
		}
		return sb.toString();
	}

}
