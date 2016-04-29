package com.masterspring.common.demo.java7.concurrency.synchronize;

public class Main {
	public static void main(String[] args) {
		Account account = new Account(1000);
		Thread companyThread = new Thread(new Company(account));
		Thread bankThread = new Thread(new Bank(account));
		companyThread.start();
		bankThread.start();

		try {
			companyThread.join();
			bankThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(account.getBalance());
	}
}
