package com.masterspring.common.demo.pattern.callback;

public class CallBackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo foo = new Foo();
		foo.setICallBack(new ICallBack(){

			public void request() {
				// TODO Auto-generated method stub
				System.out.println("call back");
			}
			
		});
	}

}
