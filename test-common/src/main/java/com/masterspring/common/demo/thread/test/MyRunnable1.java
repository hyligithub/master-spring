package com.masterspring.common.demo.thread.test;

/**
 * @author lihy 体现线程运行状态的代码示例
 */
public class MyRunnable1 implements Runnable {

	private boolean isStop;// 线程是否停止的标志

	public void run() {
		// TODO Auto-generated method stub
		if (!isStop) {
			System.out.println("thread is running");
		}

	}

	public void setStop() {
		this.isStop = true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new MyRunnable1());// 新建状态
		t.start();// 就绪状态
		try {
			t.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MyRunnable1().setStop();// 线程停止
	}

}
