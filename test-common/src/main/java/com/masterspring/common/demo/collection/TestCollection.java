package com.masterspring.common.demo.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection c = new ArrayList();
		c.add("孙悟空");
		c.add(6);
		System.out.println(c.size());
		c.remove(6);
		System.out.println(c.size());
		c.add("J2EE");
		System.out.println(c.size());
		//-----------------------------------------
		Collection books = new HashSet();
		books.add("J2EE");
		books.add("Struts2");
		System.out.println(c.containsAll(books));
		c.removeAll(books);//c集合減去books集合中的元素
		System.out.println(c);
		c.clear();
		System.out.println(c);
		
		books.retainAll(c);//books集合里只剩下c集合里也同時包含的元素
		System.out.println(books);
		
	}

}
