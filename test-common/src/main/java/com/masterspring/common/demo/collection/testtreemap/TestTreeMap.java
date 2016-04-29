package com.masterspring.common.demo.collection.testtreemap;

import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap tm = new TreeMap();
		tm.put(new M(3), "轻量级J2EE企业应用实战");
		tm.put(new M(-5), "Struts2权威指南");
		tm.put(new M(9), "ROR敏捷开发最佳实践");
		System.out.println(tm);
		// 返回该TreeMap的第一个Entry对象
		System.out.println(tm.firstEntry());
		// 返回该TreeMap的最后一个key值
		System.out.println(tm.lastKey());
		// 返回该TreeMap的比new R(2)大的最小key值。
		System.out.println(tm.higherKey(new M(2)));
		// 返回该TreeMap的比new R(2)小的最大的key－value对。
		System.out.println(tm.lowerEntry(new M(2)));
		// 返回该TreeMap的子TreeMap
		System.out.println(tm.subMap(new M(-1), new M(4)));
	}

}
