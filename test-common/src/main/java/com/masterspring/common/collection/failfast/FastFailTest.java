package com.masterspring.common.collection.failfast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lihuiyan on 2015/12/16.
 */
public class FastFailTest {

    ArrayList<String> list = new ArrayList();

    public FastFailTest() {
    }

    public void printAll() {
        for(Iterator iter = list.listIterator();iter.hasNext();)
            System.out.println(iter.next());
    }

    public class ThreadOne extends Thread {
        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                list.add(i + "");
                printAll();
            }
        }
    }

    public class ThreadTwo extends Thread {
        public void run() {
            for (int i = 10; i < 15; i++) {
                list.add(i + "");
                printAll();
            }
        }
    }

    public void execute() {
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    public static void main(String[] args) {
        new FastFailTest().execute();
    }
}
