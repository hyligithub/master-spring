package com.masterspring.common.demo.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lihy
 *分线程具体的执行过程受其他分线程的影响，必须每个分线程都执行完毕了，
 *主线程才继续往下走，而分线程如果在所有分线程执行完毕后还有其他动作，ok，还你自由，不必阻塞了
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				System.out.println("所有玩家进入第二关!");
			}

		});
		for (int i = 0; i < 4; i++) {
			new Thread(new CyclicBarrierDemo().new Player(i, cyclicBarrier))
					.start();
		}
	}

	class Player implements Runnable {
		private int id;
		private CyclicBarrier cb;

		public Player(int id, CyclicBarrier cb) {
			this.id = id;
			this.cb = cb;
		}

		public void run() {
			// TODO Auto-generated method stub
			try {
				System.out.println("玩家" + id + "正在玩第一关...");
				cb.await();
				System.out.println("玩家" + id + "进入第二关...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

		}

	}

}
