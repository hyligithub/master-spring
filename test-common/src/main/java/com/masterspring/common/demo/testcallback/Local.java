package com.masterspring.common.demo.testcallback;

public class Local implements Callback,Runnable{

	private Remote remote;
	private String message;
	public Local(Remote r,String message) {
		// TODO Auto-generated constructor stub
		this.remote = r;
		this.message=message;
	}

	public void sendMessage(){
		//当前线程名称
		System.out.println(Thread.currentThread().getName());
		//创建一个新的线程发消息
		Thread t = new Thread(this);
		t.start();
		//当前线程继续执行
		System.out.println("Message has been sent by Local~");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Local l = new Local(new Remote(),"Hello");
		l.sendMessage();
	}

	public void excute(Object... objects) {
		// TODO Auto-generated method stub
		 /**打印返回的消息**/    
        System.out.println(objects[0]);    
        /**打印发送消息的线程名称**/    
        System.out.println(Thread.currentThread().getName());   
        int[] a= (int[])objects[0];
		for(int i=0;i<a.length;i++){
			System.out.println(i);
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		remote.excuteMessage(this.message,this);
	}

}
