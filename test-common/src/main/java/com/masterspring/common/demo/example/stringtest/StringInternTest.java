package com.masterspring.common.demo.example.stringtest;

public class StringInternTest {
	public static void main(String[] args){
		String a = new String(new char[]{'a','b','c','d'});
		String b="abcd";
		String c = a.intern();
		String d = b.intern();
		if(a==c){
			System.out.println("c被加入字符串池中，没有新建对象");
		}else{
			System.out.println("c没有被加入字符串池中，新建对象");
		}
		if(b==d){
			System.out.println("d被加入字符串池中，没有新建对象");
		}else{
			System.out.println("d没有被加入字符串池中，新建对象");
		}
	}
}
