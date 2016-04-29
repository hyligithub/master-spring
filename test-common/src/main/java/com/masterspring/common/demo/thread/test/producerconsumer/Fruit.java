package com.masterspring.common.demo.thread.test.producerconsumer;

import java.util.Random;

public class Fruit {

	private int id;
	private String name;
	private static int number=0;
	private String variety;
	private String[] varietys={"苹果","香蕉","橘子","桃子","荔枝","葡萄"};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public Fruit() {
		super();
		this.variety = varietys[new Random().nextInt(6)];
		this.id = ++number;
	}

	
}
