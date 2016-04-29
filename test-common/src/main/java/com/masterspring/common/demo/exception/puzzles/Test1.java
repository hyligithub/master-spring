package com.masterspring.common.demo.exception.puzzles;

import java.io.IOException;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            System.out.println("ss");
        } catch (Exception e) {// ���IOException ��������
            System.out.println("This can't happen");
        }
    }
}
