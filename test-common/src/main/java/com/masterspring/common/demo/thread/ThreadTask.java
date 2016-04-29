package com.masterspring.common.demo.thread;

public class ThreadTask extends Thread{
	
	private ThreadPoolService service;
	
	public ThreadTask(ThreadPoolService tp){
		this.service=tp;
	}
	
	public void run(){
		while(service.isRunning()){
			TaskQueue queue = service.getTaskQueue();
			Task task = queue.getTask();
			if(task!=null){
				task.deal();
			}
			queue.finishTask(task);
		}
	}
}
