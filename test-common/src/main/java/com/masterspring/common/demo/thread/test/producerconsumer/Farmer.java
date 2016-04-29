package com.masterspring.common.demo.thread.test.producerconsumer;

import java.util.Random;

public class Farmer implements Runnable{
	
	private String name;
	private FruitBasket fb;
	public Farmer(String name,FruitBasket fb){
		super();
		this.name=name;
		this.fb=fb;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			fb.push(name, new Fruit());
			try {
				Thread.sleep(new Random().nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
