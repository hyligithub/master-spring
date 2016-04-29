package com.masterspring.common.demo.thread.test.sychronized;

public class BoyThread implements Runnable {

	private Account account;

	public BoyThread(Account a) {
		this.account = a;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("男孩去銀行取錢");
		synchronized (account) {
			System.out.println("男孩问银行卡还有多少钱");
			int blance = account.getBlance();
			System.out.println("业务员告诉男孩卡里的钱为：" + blance);
			try {
				System.out.println("男孩思考取多少钱");
				Thread.sleep(1000);
				System.out.println("男孩思考1秒钟");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int money = 5000;
			System.out.println("男孩决定取：" + money);
			account.setBlance(blance - 5000);// 修改账户信息
			System.out.println("交易完成");
			System.out.println("业务员告诉男孩卡里余额为：" + account.getBlance());
		}
	}

}
