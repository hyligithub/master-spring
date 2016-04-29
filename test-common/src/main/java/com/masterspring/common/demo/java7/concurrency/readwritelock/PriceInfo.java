package com.masterspring.common.demo.java7.concurrency.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {

	private double price1;
	private double price2;
	private ReadWriteLock rwLock;

	public PriceInfo() {
		this.price1 = 1.0;
		this.price2 = 2.0;
		this.rwLock = new ReentrantReadWriteLock();
	}

	public double getPrice1() {
		rwLock.readLock().lock();;
		double value = price1;
		rwLock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		rwLock.readLock().lock();;
		double value = price2;
		rwLock.readLock().unlock();
		return value;
	}

	public void setPrice(double p1, double p2) {
		rwLock.writeLock().lock();;
		this.price1 = p1;
		this.price2 = p2;
		rwLock.writeLock().unlock();

	}
}
