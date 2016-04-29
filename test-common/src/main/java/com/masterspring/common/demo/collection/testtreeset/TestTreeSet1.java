package com.masterspring.common.demo.collection.testtreeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<M> treeSet = new TreeSet(new Comparator(){
			public int compare(Object o1,Object o2){
				M m1 = (M)o1;
				M m2 = (M)o2;
				if(m1.age>m2.age){
					return -1;
				}else if (m1.age==m2.age){
					return 0;
				}else {
					return 1;
				}
			}
		});
		
		treeSet.add(new M(9));
		treeSet.add(new M(-2));
		treeSet.add(new M(3));
		System.out.println(treeSet);
	}

}
