package com.masterspring.common.demo.suanfa.test;

public class SelectSort {
	
	public void selectSort(int a[]){
		int minIndex;
		for(int i=0;i<a.length;i++){
			minIndex=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[minIndex]){
					minIndex=j;
				}
			}
			if(minIndex!=i){
				int tmp = a[i];
				a[i]=a[minIndex];
				a[minIndex]=tmp;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectSort ss = new SelectSort();
		int a[]={7,3,5,2,53,52};
		ss.selectSort(a);
		for(int i:a){
			System.out.println(i);
		}
	}

}
