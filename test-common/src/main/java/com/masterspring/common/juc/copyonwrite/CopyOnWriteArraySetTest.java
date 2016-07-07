package com.masterspring.common.juc.copyonwrite;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by lihuiyan on 2015/5/7.
 */
public class CopyOnWriteArraySetTest {
    private static Set<Student> set = new CopyOnWriteArraySet<Student>();

    public static void main(String[] args) {

        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }

    private static void printlnALLSet() {
        Iterator iterator = set.iterator();
//        System.out.println(Thread.currentThread().getName());
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

        Student student = null;

        public void run() {
            int i = 0;
            while (i++ < 10) {
                student = new Student(i, i + "");
                set.add(student);
                printlnALLSet();
            }
            System.out.println(set.size());
        }
    }
}
