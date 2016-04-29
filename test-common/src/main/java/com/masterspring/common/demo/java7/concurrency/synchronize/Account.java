package com.masterspring.common.demo.java7.concurrency.synchronize;

import java.util.concurrent.TimeUnit;

public class Account {
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void addAmount(double amount) {
		double tmp = balance;
		tmp += amount;
		balance = tmp;
	}

	public synchronized void subAmount(double amount) {
		double tmp = balance;
		tmp -= amount;
		balance = tmp;
	}
}
