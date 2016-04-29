package com.masterspring.common.demo.concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		// ConcurrentHashMap
		Map<String, String> myMap = new ConcurrentHashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "1");
		myMap.put("3", "1");
		myMap.put("4", "1");
		myMap.put("5", "1");
		myMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: " + myMap);
		Iterator<String> it = myMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("3"))
				myMap.put(key + "new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: " + myMap);

		// HashMap
		Map<String, String> myMap1 = new HashMap<String, String>();
		myMap1.put("1", "1");
		myMap1.put("2", "1");
		myMap1.put("3", "1");
		myMap1.put("4", "1");
		myMap1.put("5", "1");
		myMap1.put("6", "1");
		System.out.println("HashMap before iterator: " + myMap1);
		Iterator<String> it1 = myMap1.keySet().iterator();

		while (it1.hasNext()) {
			String key = it1.next();
			if (key.equals("3"))
				myMap1.put(key + "new", "new3");
		}
		System.out.println("HashMap after iterator: " + myMap1);
	}

}
