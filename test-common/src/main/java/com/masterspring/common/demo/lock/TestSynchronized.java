package com.masterspring.common.demo.lock;

import java.util.ArrayList;
import java.util.List;

public class TestSynchronized {

	List<Object> eggs = new ArrayList<Object>();
	
	public volatile int a;

	public synchronized Object getEgg() {
		if (eggs.size() == 0) {
			try {
				wait();//如果盘子里的鸡蛋为0，释放锁
			} catch (Exception e) {

			}

		}
		Object egg = eggs.get(0);
		eggs.clear();
		notify();//唤醒阻塞队列的某线程到就绪队列
		return egg;
	}

	public synchronized void putEgg(Object egg) {
		if (eggs.size() > 0) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		eggs.add(egg);
		notify();//唤醒阻塞队列的某线程到就绪队列
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
