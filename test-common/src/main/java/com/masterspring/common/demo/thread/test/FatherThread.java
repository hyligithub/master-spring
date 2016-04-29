package com.masterspring.common.demo.thread.test;

public class FatherThread implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("爸爸想抽烟，发现烟抽完了");
		System.out.println("爸爸让儿子去买包红塔山");

		Thread son = new Thread(new SonThread());
		son.start();
		System.out.println("爸爸等儿子买烟回来");
		try {
			son.join(); // join含义：等待son线程执行完毕，father线程才继续执行
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("爸爸出门去找儿子跑哪去了");
			System.exit(1);

		}
		System.out.println("爸爸高兴的接过烟开始抽，并把零钱给了儿子");

	}

}
