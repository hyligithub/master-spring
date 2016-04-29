package com.masterspring.common.demo.suanfa;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a[]={6,5,8,2,3};
			bubbleSort(a);
			for(int i:a){
				System.out.println(i);
			}
	}
	public static void bubbleSort(int a[]){
		int length= a.length;
		int tmp;
		int times=0;
		for(int i=1;i<length;i++){
			times++;
			for(int j=0;j<length-i;j++){
				if(a[j]>a[j+1]){
					tmp = a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
				}
			}
		}
		System.out.println("times:="+times);
	}
}
