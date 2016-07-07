package com.masterspring.common.collection.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 4 /*
 5  * @desc java集合中Fast-Fail的测试程序。
 6  *
 7  *   fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 8  *   fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 9  *
 10  *   本例中，分别测试ArrayList和CopyOnWriteArrayList这两种情况。ArrayList会产生fast-fail事件，而CopyOnWriteArrayList不会产生fast-fail事件。
 11  *   (01) 使用ArrayList时，会产生fast-fail事件，抛出ConcurrentModificationException异常；定义如下：
 12  *            private static List<String> list = new ArrayList<String>();
 13  *   (02) 使用时CopyOnWriteArrayList，不会产生fast-fail事件；定义如下：
 14  *            private static List<String> list = new CopyOnWriteArrayList<String>();
 15  *
 16  * @author skywang
 * Created by lihuiyan on 2015/4/20.
 */
public class FailFast {
        private static List<String> list = new ArrayList();
//    private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {

        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static void printlnAllByIterator() {
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

    private static void printlnAllByFor() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static class ThreadOne extends Thread {
        public void run() {
            int i = 0;
            while (i < 6) {
                list.add(String.valueOf(i));
                printlnAllByIterator();
                i++;
            }
        }
    }

    public static class ThreadTwo extends Thread {
        public void run() {
            int i = 10;
            while (i < 16) {
                list.add(String.valueOf(i));
                printlnAllByIterator();
                i++;
            }
        }
    }
}
