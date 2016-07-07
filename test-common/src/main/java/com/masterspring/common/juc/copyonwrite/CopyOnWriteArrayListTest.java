package com.masterspring.common.juc.copyonwrite;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by lihuiyan on 2015/5/7.
 */
public class CopyOnWriteArrayListTest {

    private static List<String> list = new CopyOnWriteArrayList<String>();//换成 ArrayList 抛异常

    private static Set<Student> set = new CopyOnWriteArraySet<Student>();

    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }

    private static void printAll() {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
    }

    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                list.add(Thread.currentThread().getName() + "-" + i);
                printAll();
            }
        }
    }

    private static void printlnALLSet() {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
        System.out.println();
    }

}
