package com.masterspring.common.arithmetic.com.sortarithmetic;

/**
 * Created by lihuiyan on 2015/5/17.
 */
public class BubbleSort {

    private void bubbleSort(int[] a) {
        int i, j;
        boolean flag = true;
        if (a == null) {
            return;
        }
        int n = a.length;
        for (i = n - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20, 10, 40, 5, 60, 30};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
