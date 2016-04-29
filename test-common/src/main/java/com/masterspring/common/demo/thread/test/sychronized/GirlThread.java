package com.masterspring.common.demo.thread.test.sychronized;

public class GirlThread implements Runnable {
	Account account;

	public GirlThread(Account a) {
		this.account = a;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("女孩決定刷卡买一件衣服");
		synchronized (account) {
			int blance = account.getBlance();
			System.out.println("刷卡机显示卡的余额为:" + blance);
			int paycount = 5000;
			System.out.println("女孩要买衣服的价格是：" + paycount);
			System.out.println("女孩刷卡交易");
			account.setBlance(blance - paycount);// 设置账户余额
			System.out.println("交易完成");
			System.out.println("账户余额为：" + account.getBlance());
		}
	}

}
