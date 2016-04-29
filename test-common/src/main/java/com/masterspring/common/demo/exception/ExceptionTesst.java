package com.masterspring.common.demo.exception;

public class ExceptionTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ss = getss();
		System.out.println(ss);
	}

	public static int getss() {
		try {
			String aa = null;
			aa.toString();
			return 11;
		} catch (Exception e) {
//			throw new RuntimeException(e);
		}
		return 0;
	}

}
