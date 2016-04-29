package com.masterspring.common.demo.suanfa.test;

public class BubbleSort {

	public void bubbleSort(int a[]) {
		int len = a.length;
		int tmp;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (a[j] > a[j + 1]) {
					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 8, 2, 5, 63, 21, 53, 9 };
		BubbleSort b = new BubbleSort();
		b.bubbleSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
