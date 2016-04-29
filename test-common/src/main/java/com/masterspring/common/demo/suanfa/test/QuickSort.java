package com.masterspring.common.demo.suanfa.test;

/**
 * @author lihy
 * 快速排序
 *
 */
public class QuickSort {

	public void quickSort(int a[], int start, int end) {
		int i = start, j = end;
		int tmp = a[start];
		while (i < j) {
			while (i < j && a[j] > tmp) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && a[i] <= tmp) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = tmp;
		if (start < i - 1)
			quickSort(a, start, i - 1);

		if (end > i + 1)
			quickSort(a, i + 1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 23, 2, 4, 15, 53, 12, 1 };
		QuickSort qk = new QuickSort();
		qk.quickSort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.println(i);
		}
	}

}
