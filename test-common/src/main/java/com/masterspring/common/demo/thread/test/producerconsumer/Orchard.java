package com.masterspring.common.demo.thread.test.producerconsumer;

public class Orchard {

	// TODO Auto-generated method stub
	public static void main(String[] args) {
		FruitBasket fruitBasket = new FruitBasket();
		Thread farmerThread1 = new Thread(new Farmer("农夫1", fruitBasket));
		Thread farmerThread2 = new Thread(new Farmer("农夫2", fruitBasket));
		Thread farmerThread3 = new Thread(new Farmer("农夫3", fruitBasket));
		Thread childThread1 = new Thread(new Child("小孩1", fruitBasket));
		Thread childThread2 = new Thread(new Child("小孩2", fruitBasket));
		Thread childThread3 = new Thread(new Child("小孩3", fruitBasket));
		farmerThread1.start();
		farmerThread2.start();
		farmerThread3.start();
		childThread1.start();
		childThread2.start();
		childThread3.start();

	}

}
