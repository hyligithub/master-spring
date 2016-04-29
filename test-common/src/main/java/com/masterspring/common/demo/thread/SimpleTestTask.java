package com.masterspring.common.demo.thread;

public class SimpleTestTask extends Task{

	@Override
	public void deal() {
		// TODO Auto-generated method stub
		
		System.out.println("simpleTask");
		
	}
	public static void main(String[] arags) throws InterruptedException{
		ThreadPoolService service = new ThreadPoolService();
		service.start();
		for(int i =0;i<10;i++){
			service.runTask(new SimpleTestTask());
		}
		Thread.sleep(1000);
		service.stop();
	}
}
