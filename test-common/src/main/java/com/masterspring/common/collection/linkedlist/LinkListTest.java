package com.masterspring.common.collection.linkedlist;

import java.util.LinkedList;

/**
 * Created by lihuiyan on 2015/12/21.
 */
public class LinkListTest {
    public static void main(String[] args) {
        linkListAsLIFO();
        linkListAsFIFO();
    }

    /*
    LinkList 作为 堆栈
     */
    public static void linkListAsLIFO() {
        LinkedList<String> stack = new LinkedList<String>();
        stack.push("10");
        stack.push("20");
        stack.push("30");
        for (String value : stack) {
            System.out.println(value);
        }
    }

    public static void linkListAsFIFO() {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add("10");
        queue.add("20");
        queue.add("30");
        for (String value : queue) {
            System.out.println(value);
        }
    }
}
