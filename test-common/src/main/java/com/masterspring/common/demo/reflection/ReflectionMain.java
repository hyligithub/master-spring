package com.masterspring.common.demo.reflection;

public class ReflectionMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = new Customer("Tome", 32);
		customer.setId(1L);
		Customer copyCustomer = (Customer) new ReflectTester().copy(customer);
		System.out.println("Copy information:" + copyCustomer.getId() + "---"
				+ copyCustomer.getName() + "----" + copyCustomer.getAge());
	}
}
