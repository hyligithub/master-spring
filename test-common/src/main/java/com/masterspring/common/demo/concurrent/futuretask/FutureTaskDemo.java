package com.masterspring.common.demo.concurrent.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lihy
 *分线程汇总
 */
public class FutureTaskDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callable otherPerson = new FutureTaskDemo().new OtherPerson();
		// 由此任務去执行
		FutureTask ft = new FutureTask(otherPerson);

		Thread newThread = new Thread(ft);// 使用ft创建一个线程，该线程执行抢葵花宝典的任务
		System.out.println("newThread线程启动，启动时间：" + System.nanoTime());
		newThread.start();
		System.out.println("主线程——东方不败，开始执行其他任务");

		System.out.println("东方不败开始准备小刀，消毒...");
		//兄弟线程在后台的计算线程是否完成，如果未完成则等待阻塞
		while (!ft.isDone()) {
			try {
				Thread.sleep(500);
				System.out.println("东方不败：“等兄弟回来了，我就和小弟弟告别……颤抖……”");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("newhread线程执行完毕，此时时间为" + System.nanoTime());
		String result = null;
		try {
			result = (String) ft.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		if ("OtherPerson:经过一番厮杀,得到<<葵花宝典>>".equals(result)) {
			System.out.println("兄弟，干得好，我挥刀自宫了啊！");
		} else {
			System.out.println("还好我没自宫！否则白白牺牲了……");
		}

	}

	@SuppressWarnings("all")
	class OtherPerson implements Callable {

		@Override
		public Object call() throws Exception {
			// TODO Auto-generated method stub
			Thread.sleep(5000);
			String result = "OtherPerson:经过一番厮杀,得到<<葵花宝典>>";
			System.out.println(result);
			return result;
		}

	}
}
