package com.masterspring.common.generic.generator;

import java.util.Iterator;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    private int n = 0;

    public IterableFibonacci(int count) {
        n = count;
    }

    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            //末端哨兵，判断何时停止
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }


    public static void main(String[] args) {

        for (int i : new IterableFibonacci(18)) {
            System.out.println(i + " ");
        }

    }
}