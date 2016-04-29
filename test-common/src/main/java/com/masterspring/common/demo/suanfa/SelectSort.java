package com.masterspring.common.demo.suanfa;

/**
 * @author lihy 直接选择排序 思想：从待排序的数据集合中选择最小的数据与原始数据集合中的第一个位置上的数据进行交换
 *         然后从第二个位置开始选择最小的数据与原始数据集合中的第二个位置上的数据进行交换，如此重复
 */
public class SelectSort {

	public void selectSort(int[] a) {
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = a[i];
				a[i] = a[min];
				a[min] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 4, 5, 6, 1, 7 };
		SelectSort ss = new SelectSort();
		ss.selectSort(a);
		for (int i : a) {
			System.out.println(i);
		}

	}

}
