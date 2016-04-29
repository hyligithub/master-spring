package com.masterspring.common.demo.dmyh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mapTest();
//		stringTest();
//		testList();
//		testArray();
	}
	
	public static void testArray(){
		String[] aa = {};
		try{
		for(int i=0;i<5;i++){
			aa[i]=String.valueOf(i);
			System.out.print(i);
			}
		}catch(NullPointerException  e){
			e.printStackTrace();
		}	
		}
	
	public static void testList() {
		List<String> list = new ArrayList();
		Long ll = 0L;
		ll.toString();
//		for(String s: list){
			System.out.println(ll.toString());
//		}
	}
	public static void stringTest(){
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.toString());
		System.out.println(String.valueOf(sb));
		
		StringBuffer ss = new StringBuffer("999999999999");
		ss.append("1").append("2").append("1");
		String str = ss.substring(0, ss.length()-1);
//		ss = new StringBuffer();
		ss.append(str);
		System.out.println(ss.toString());
	}
	public static void mapTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("2", "a");
		map.put("4", "b");
		map.put("5", "c");
//		if(!map.isEmpty()){
//		String s =	map.keySet().iterator().next();
//		System.out.println(s);
//		}
		Set<String> s = map.keySet();
		for(String a :s){
			System.out.println(a);
		}
		
//		for (Entry<String, String> m : map.entrySet()) {
//			String key = m.getKey();
//			String value = m.getValue();
//			System.out.println(key + "---------key");
//			System.out.println(map.get(key) + "---------key");
//
//		}
//		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
//		while (iter.hasNext()) {
//			Map.Entry<String, String> entry = iter.next();
//			String key = entry.getKey();
//			String value = entry.getValue();
//			System.out.println(key + "---------key");
//			System.out.println(value + "---------key");
//		}
//
//		Set<String> set = map.keySet();
//		for (String s : map.keySet()) {
//			String value = map.get(s);
//		}
	}
	public static String doss(){
		String ss = new String();
		return ss;
	}
}
