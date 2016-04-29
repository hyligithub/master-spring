package com.masterspring.common.demo.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolService {

	public static final int THREAD_COUNT=5;//线程数
	
	private Status state = Status.NEW;
	
	private TaskQueue queue = new TaskQueue();//任务队列
	
	private List<Thread> threads = new ArrayList<Thread>();//工作线程列表
	
	public ThreadPoolService(){
		for(int i=0;i<this.THREAD_COUNT;i++){
			Thread t = new ThreadTask(this);
			threads.add(t);
		}
	}
	//启动服务
	public void start(){
		this.state = Status.RUNNING;
		for(int i=0;i<this.THREAD_COUNT;i++){
			threads.get(i).start();;
		}
	}
	
	public void stop(){
		this.state=Status.TERMINATED;
	}
	
	public boolean isRunning(){
		return state == Status.RUNNING;
	}
	//执行任务
	public void runTask(Task task){
		queue.addTask(task);
	}
	
	protected TaskQueue getTaskQueue(){
		return queue;
	}
	public enum Status{
		NEW,
		RUNNING,
		TERMINATED
	}

	public Status getState() {
		return state;
	}

	public void setState(Status state) {
		this.state = state;
	}
}
