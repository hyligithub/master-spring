package com.masterspring.common.collection.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by lihuiyan on 2015/4/21.
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 6; i++) {
            stack.push(String.valueOf(i));
        }
        iteratorThroughIterator(stack);

        int pos = stack.search("2");
        System.out.println("the position of 2 is: " + pos);

        stack.pop();
        iteratorThroughRandomAccess(stack);

        stack.peek();
        iteratorThroughRandomAccess(stack);

        System.out.println(stack.peek());
    }


    private static void iteratorThroughRandomAccess(Stack stack) {
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }

    private static void iteratorThroughIterator(Stack stack) {
        for (Iterator iterator = stack.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }
}
