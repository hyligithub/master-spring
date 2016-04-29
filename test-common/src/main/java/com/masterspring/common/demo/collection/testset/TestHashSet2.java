package com.masterspring.common.demo.collection.testset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<R> hashSet = new HashSet<R>();
		hashSet.add(new R(-9));
		hashSet.add(new R(5));
		hashSet.add(new R(-3));
		hashSet.add(new R(-9));
		System.out.println(hashSet);//hashSet中的元素是有序的
		
		Iterator<R> i = hashSet.iterator();
		R first =(R)i.next();//指向set的第一个元素
		first.count = -20;//first指向元素值发生改变 ，但是地址没有改变
		System.out.println(hashSet);
		
		hashSet.remove(new R(-3));
		
		System.out.println(hashSet.contains(new R(-3)));
		System.out.println(hashSet.contains(new R(-9)));
	}

}
