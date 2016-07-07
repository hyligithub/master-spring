package com.masterspring.common.basic.reference;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class ReferenceTest {
    public ReferenceTest() {

    }

    public static void drainMemory()

    {
        String[] array = new String[1024 * 10];
        for (int i = 0; i < 1024 * 10; i++) {
            for (int j = 'a'; j < 'z'; j++) {
                array[i] += (char) j;
            }
        }
    }
}
