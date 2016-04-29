package com.masterspring.common.demo.example.polymorphism;

public class CarSeller {

	public Car car;

	public void setCar(Car car) {
		System.out.println(car.getName()+"---"+car.getPrice());
	}
	
	public static void main(String[] args){
		CarSeller c= new CarSeller();
		c.setCar(new BmwCar());
		c.setCar(new QQCar());
	}
}
