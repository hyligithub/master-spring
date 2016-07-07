package com.masterspring.common.arithmetic.com.sortarithmetic;

/**
 * Created by lihuiyan on 2015/5/17.
 */
public class QuickSort {

    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int l = left;
            int r = right;
            int flagValue = array[l];//���ֵ
            while (l < r) {
                while (l < r && array[r] > flagValue)//����������С��flagValue��ֵ
                    r--;
                if (l < r)
                    array[l++] = array[r];
                while (l < r && array[l] < flagValue)//���������Ҵ���flagValue��ֵ
                    l++;
                if (l < r)
                    array[r--] = array[l];
            }
            array[l] = flagValue;
            quickSort(array, left, l - 1);
            quickSort(array, l + 1, right);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {30, 40, 60, 10, 20, 50};
        quickSort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
