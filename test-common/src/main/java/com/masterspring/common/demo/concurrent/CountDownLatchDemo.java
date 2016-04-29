package com.masterspring.common.demo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author lihy 这里大家也看到了CountDownLatch与FutureTask的区别。
 *         CountDownLatch侧重的是分线程的完成个数，
 *         每次完成一个分线程，等待数目减少一个，等待线程为0的时候，主线程的就不阻塞了，开始往下走。
 *         而分线程一旦调用countDownLatch.countDown
 *         ()方法，就代表分线程任务搞定，主线程就不会因为你的其他事情而不能往下走，完成任务了，小老婆们也可以去旅旅游，休息休息！
 *         而FutureTask则是注重执行结果的，主线程需要它的确切结果。所以futureTask执行的call()有返回值。
 */
public class CountDownLatchDemo implements Runnable {
	private int id;
	private CountDownLatch countDownLatch;

	public CountDownLatchDemo(int id, CountDownLatch cdl) {
		this.id = id;
		this.countDownLatch = cdl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cdl = new CountDownLatch(8);
		for (int i = 0; i < 8; i++) {
			new Thread(new CountDownLatchDemo(i, cdl)).start();
		}
		try {
			System.out.println("韦小宝等着等着8本四十二章……");
			// 韦小宝等着等着
			cdl.await();
			// 等待运动员到达终点
			System.out.println("8本四十二章经找寻完成，可以寻宝了！");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("韦小宝第" + (id + 1) + "老婆开始找<42章经>");
			Thread.currentThread().sleep(id * 1000);
			System.out.println("韦小宝第" + (id + 1) + "老婆找到<42章经>");
			// 计数器将等待数字-1
			countDownLatch.countDown();
			System.out.println("第" + (id + 1) + "小老婆继续干其他事情");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
