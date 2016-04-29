package com.masterspring.common.demo.exception.puzzles;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class Test4 {

    private Test4 test4 = new Test4();

    public Test4() throws Exception {
        throw new Exception("i am not coming out");
    }

    public static void main(String[] args) {
        try {
            Test4 a = new Test4();
            System.out.println("Surprise!");
        } catch (Exception e) {
            System.out.println("I told you so");
        }
    }
}
