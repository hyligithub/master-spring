package com.masterspring.common.demo.concurrent.threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Timer task started at:"+new Date());
		completeTask();
		System.out.println("Timer task finished at:"+new Date());

	}

	private void completeTask(){
		
		try {
			Thread.sleep(20000);//花费20秒完成任务
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimerTask timerTask = new MyTimerTask();
		Timer timer = new Timer(true);//running timer task as deamon task
		timer.schedule(timerTask, 0, 10*1000);
		System.out.println("TimerTask started");
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask canceled");
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
