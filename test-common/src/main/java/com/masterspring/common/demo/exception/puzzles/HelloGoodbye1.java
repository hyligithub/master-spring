package com.masterspring.common.demo.exception.puzzles;



/**
 * Created by lihuiyan on 2015/5/20.
 */
public class HelloGoodbye1 {
    public static void main(String[] args) {
        System.out.println("hello world");
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        System.out.println("Goodbye world");
                    }
                });
        System.exit(0);
    }
}
