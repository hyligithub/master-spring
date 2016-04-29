package com.masterspring.common.demo.collection.testtreeset;

import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Z> treeSet = new TreeSet<Z>();
		Z z1 = new Z(6);
		treeSet.add(z1);
		System.out.println(treeSet.add(z1));
		System.out.println(treeSet);
		
		treeSet.first().age = 9;
		
		System.out.println(treeSet.last().age);
	}

}
