package com.masterspring.common.demo.collection.testset;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Object> hashSet = new HashSet<Object>();
		hashSet.add(new C());
		hashSet.add(new C());
//		hashSet.add(new B());
//		hashSet.add(new B());
//		hashSet.add(new R(1));
//		hashSet.add(new R(1));
		
//		String a = new String("1");
//		String b = new String("1");
//		hashSet.add(a);
//		hashSet.add(b);
		System.out.println(hashSet.size());
		
	}

}
