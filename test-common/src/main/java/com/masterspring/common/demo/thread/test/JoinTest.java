package com.masterspring.common.demo.thread.test;

public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("爸爸和儿子的故事");
		Thread father = new Thread(new FatherThread());
		father.start();
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// father.interrupt();
	}

}
