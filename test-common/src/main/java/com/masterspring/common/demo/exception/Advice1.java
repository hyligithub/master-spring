package com.masterspring.common.demo.exception;

/**
 * Created by lihuiyan on 2015/5/19.
 * try catch �Ĵ����ִ��ʱ�䳤
 */
public class Advice1 {

    public static void main(String[] args) {
        int[] a = new int[5];
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            endByRange(a);
//            endByException(a);
        }
        long e = System.currentTimeMillis();
        System.out.println((e - s) + "ms");
    }

    private static void endByException(int[] array) {
        try {
            int i = 0;
            while (true) {
                array[i++] = 0;
            }
        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
        }
    }

    private static void endByRange(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }
}
