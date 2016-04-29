package com.masterspring.common.demo.thread.test.producerconsumer;

import java.text.DecimalFormat;

public class FruitBasket {
	private Fruit[] fruits = new Fruit[10];// 水果筐最多放10个水果

	private int index = 0;// 水果索引

	public boolean isEmpty() {
		return index == 0 ? true : false;
	}

	public boolean isFull() {
		return index == fruits.length ? true : false;
	}

	public synchronized void push(String name, Fruit fruit) {
		while (isFull()) {
			try {// 如果篮子满了，需要等待，释放锁
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fruits[index++] = fruit;
		System.out.println(name + " 向水果框中放入编号为" + fruit.getId() + "的"
				+ fruit.getVariety());
		this.display();
		this.notify();
	}

	public synchronized Fruit pop(String name) {
		while (isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Fruit fruit = fruits[--index];
		System.out.println(name + " 从水果框中拿出编号为" + fruit.getId() + "的"
				+ fruit.getVariety());
		this.display();
		this.notify();
		return fruit;
	}

	public void display() {
		for (int i = 0; i <index; i++)
			System.out.printf("%-10s",
					" NO:" + new DecimalFormat("00").format(fruits[i].getId())
							+ fruits[i].getVariety() + " |");
		for (int i = index; i < fruits.length; i++) {
			System.out.printf("%-10s", "   【" + (i + 1) + "】   |");
		}
		System.out.println();
	}

}
