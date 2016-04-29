package com.masterspring.common.demo.exception.puzzles;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class HelloGoodBye {
    public static void main(String[] args) {

        try {
            System.out.println("hello world");
            System.exit(0);
        } finally {
            System.out.println("good bye");
        }
    }
}
