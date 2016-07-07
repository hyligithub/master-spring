package com.masterspring.common.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * Created by lihuiyan on 2015/4/20.
 */
public class ArrayListRandomAccessTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        isRandomAccessSupported(list);
//        iteratorThroughFor(list);
//        iteratorThroughIterator(list);
        iteratorThroughRandomAccess(list);
    }

    private static void isRandomAccessSupported(List list) {
        if (list instanceof RandomAccess) {
            System.out.println("RandomAccess implemented!");
        } else {
            System.out.println("RandomAccess not implemented!");
        }
    }

    private static void iteratorThroughFor(List<Integer> list) {
        long startTime = 0L;
        long endTime = 0L;
        startTime = System.currentTimeMillis();
        for (Object o : list)
            ;
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor " + interval + " ms");
    }

    private static void iteratorThroughRandomAccess(List list) {
        long startTime = 0L;
        long endTime = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess " + interval + " ms");
    }

    private static void iteratorThroughIterator(List list) {
        long startTime = 0L;
        long endTime = 0L;
        startTime = System.currentTimeMillis();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            iterator.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator " + interval + " ms");
    }
}
