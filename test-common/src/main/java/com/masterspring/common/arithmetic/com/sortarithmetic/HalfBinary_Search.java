package com.masterspring.common.arithmetic.com.sortarithmetic;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/27.
 * 折半查找
 */
public class HalfBinary_Search {

    public static void main(String[] args) {
        int[] array = {10, 22, 34, 63, 25, 621, 51};
        if (search(array, 34)) {
            PrintUtil.print("OK");
        }
    }

    public static boolean search(int[] array, int k) {
        int low = 0;
        int height = array.length - 1;
        int mid;
        while (low <= height) {
            mid = (low + height) / 2;
            if (k < array[mid]) {
                height = mid - 1;
            } else if (k > array[mid]) {
                low = mid + 1;
            } else {
                PrintUtil.print("array 中存在" + k);
                return true;
            }
        }
        return false;
    }
}
