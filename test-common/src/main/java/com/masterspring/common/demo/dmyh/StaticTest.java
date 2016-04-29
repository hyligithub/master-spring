package com.masterspring.common.demo.dmyh;

public class StaticTest {
	private static TT tt = new TT();
	public void doss(){
		TT.status = true;
		tt.init();
	}

	
}
class TT{
	public static  boolean status = false;
	
	public void init(){
		
	}
//	public static boolean isStatus() {
//		return status;
//	}
//
//	public static void setStatus(boolean status) {
//		TT.status = status;
//	}
}