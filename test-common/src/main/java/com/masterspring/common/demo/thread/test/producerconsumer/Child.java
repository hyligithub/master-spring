package com.masterspring.common.demo.thread.test.producerconsumer;

import java.util.Random;

public class Child implements Runnable {

	// TODO Auto-generated method stub
	private String name;
	/*** 水果框 */
	private FruitBasket fruitBasket;

	/*** 小孩会不停地重复这一系列动作：从水果框中拿出水果吃，然后随机休息0-5秒钟 */
	public void run() {
		while (true) {
			fruitBasket.pop(name);
			try {
				Thread.sleep(new Random().nextInt(5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Child(String name, FruitBasket fruitBasket) {
		super();
		this.name = name;
		this.fruitBasket = fruitBasket;
	}

}
