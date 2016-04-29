package com.masterspring.common.demo.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class TestIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new HashSet();
		c.add("J2EE");
		c.add("Spring");
		c.add("Hibernate");
		Iterator i = c.iterator();
		while(i.hasNext()){
			String book = (String)i.next();
			System.out.println(book);
			if(book.equals("J2EE")){
				i.remove();
			}
			book="portal";//不会改变集合元素本身
		}
		System.out.println(c);
	}

}
