package com.masterspring.common.demo.suanfa;

import java.util.Arrays;

/**
 * @author lihy
 * 输入N个数字，逗号分隔，可选择升序和降序排列
 */
public class SplitStringComma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str
		= new String("8,2,4,5,3,1");
		String[] array = str.split(",");
		Arrays.sort(array);//asc
		for(int i = 0;i<array.length;i++){
			System.out.println(array[i]);
		}
		for(int i=array.length-1;i>=0;i--){
			System.out.println(array[i]);
		}
		new SplitStringComma().aa();
	}
	/**
	 * 两个数组合并后进行排序输出
	 */
	private void aa(){
		String[] array1 = new String[]{"3","5","1","4"};
		String[] array2 = new String[]{"4","2","7","6"};
		Arrays.sort(array1);
		Arrays.sort(array2);
		String[] array3 = new String[array1.length+array2.length];
		for(int i =0;i<array1.length;i++){
			array3[i]=array1[i];
		}
		for(int j=0;j<array2.length;j++){
			array3[array1.length+j]=array2[j];
		}
		Arrays.sort(array3);
		for(int m =0;m<array3.length;m++){
			System.out.println(array3[m]);
		}
		
	}

}
