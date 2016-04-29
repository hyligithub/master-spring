package com.masterspring.common.demo.example.stringtest;

public class StringStaticTest {

	private static final String A ="ab";
	private static final String B ="cd";
	private static final String C;
	private static final String D;
	static{
		C="ab";
		D="cd";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a=A+B;
		String b="abcd";
		String c=C+D;
		if(a==b){
			System.out.println("a和b是同一个对象");
		}
		if(b.equals(c)){
			System.out.println("c和b是同一个对象");
		}else
		{
			System.out.println("c和b不是同一个对象");
		}
	}

}
