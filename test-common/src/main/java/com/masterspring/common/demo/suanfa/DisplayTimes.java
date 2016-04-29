package com.masterspring.common.demo.suanfa;

import java.util.Arrays;

/**
 * @author lihy
 * 给你一组字符如{1，3，4，7，2，1，1，5，2}，让你输出里面出现次数最多且数
值最大的一个，出现几次 
 *
 */
public class DisplayTimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3, 4, 5, 1, 1, 6, 5, 8, 5 };
		Arrays.sort(a);
		 for (int i = 0; i < a.length; i++) {
		 System.out.print((a[i]+" "));
		 }
		 System.out.println();
		 
		 int maxNumber = a[a.length-1];
		 int maxCount = 1;
		 int curNumber = a[a.length-1];
		 int curCount = 1;
		 
		 for(int i = a.length-1 ;i>0;i--){
			 curNumber = a[i];
			 if(a[i]==a[i-1]){
				 curCount++;
				 
			 }else {
				 System.out.println("i="+i+"curCount="+curCount+"maxCount="+maxCount+"maxNumber="+maxNumber);
				 if(curCount>maxCount){
					 maxCount = curCount;
					 maxNumber = curNumber;
				 }
				 curCount =1;
			 }
		 }
		 if(curCount>maxCount){
			 maxCount = curCount;
		 }
		 System.out.println("curCount="+curCount+"maxCount="+maxCount+"maxNumber="+maxNumber);
		 
	}

}
