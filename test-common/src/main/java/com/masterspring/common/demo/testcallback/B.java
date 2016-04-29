package com.masterspring.common.demo.testcallback;


public class B {

	public void excute(InterfaceA a){
		a.doSth();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new B().method();
	}
	public void method(){
		this.excute(new InterfaceA(){

			public void doSth() {
				// TODO Auto-generated method stub
				System.out.println("LLL");
			}
			
		});
	}
}
