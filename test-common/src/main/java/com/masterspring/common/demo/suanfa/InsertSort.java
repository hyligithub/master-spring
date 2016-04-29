package com.masterspring.common.demo.suanfa;

/**
 * @author lihy
 *直接插入排序
 *思想：待排序集合分成一个有序表和一个无需表，初始有序表只有一个元素，从无需表
 *取出一个元素插入到有序表的合适位置
 */
public class InsertSort {
	
	public void insertSort(int a[]){
		for(int i=1;i<a.length;i++){
			int j=i;
			int tmp =a[i];//待排序元素
			while(j>0&&a[j-1]>tmp){
				a[j]=a[j-1];
				--j;
			}
			a[j]=tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
