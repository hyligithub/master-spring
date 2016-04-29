package com.masterspring.common.demo.suanfa;

/**
 * @author lihy
 *两个有序数组合并为一个有序数组
 *
 *思想：先一次比较两个数组，按照小的就传入新的数组，当比较完成后可能还有
 *一个数组很长，留下的数组在新数组末尾插入即可。
 */
public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a={1,3,5,7,9};
		int[]b={2,4,6,8,10,12,14};
		int[]result = mergeList(a,b);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] mergeList(int[]a ,int[]b){
		int result[];
		if(checkSort(a)&&checkSort(b)){
			result = new int[a.length+b.length];
			int i=0,j=0,k=0;
			while(i<a.length&&j<b.length){
				if(a[i]<b[j])
					result[k++]=a[i++];
				else 
					result[k++]=b[j++];
			}
			while(i<a.length){
				result[k++]=a[i++];
			}
			while(j<b.length){
				result[k++]=b[j++];
			}
			return result;
		}else{
			return null;
		}
		
	}
	private static boolean checkSort(int[] aa){
		
		for(int i=0;i<aa.length-1;i++){
			if(aa[++i]>aa[i]){
				return false;
			}
		}
		return true;
		
	}

}
