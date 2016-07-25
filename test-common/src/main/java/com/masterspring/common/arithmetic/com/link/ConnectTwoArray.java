package com.masterspring.common.arithmetic.com.link;

/**
 * Created by lihuiyan on 2016/7/22.
 */
public class ConnectTwoArray {
    private static int[] a = {2, 4, 6, 7, 3, 1};
    private static int[] b = {88, 23, 56, 1, 6, 8};
    private int[] c;

    public ConnectTwoArray() {
        c = new int[a.length + b.length];
    }

    public int[] connect() {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else
                c[k++] = b[j++];
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }
}
