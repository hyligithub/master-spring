package com.masterspring.common.demo.testcallback;

public class Remote {

	public Remote() {
		// TODO Auto-generated constructor stub
	}
	int[] a = new int[10];
	public void preReturn(){
		System.out.println("我现在处理点别的事情");
		for(int i=0;i<10;i++){
			a[i]=i;
		}
	}
	public void excuteMessage(String msg,Callback callback){
		System.out.println("收到你的消息:"+msg);
		this.preReturn();
		System.out.println("现在开始处理消息");
		//执行回调
		callback.excute(a);
	}

}
