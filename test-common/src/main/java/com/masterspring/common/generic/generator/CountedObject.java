package com.masterspring.common.generic.generator;

/**
 * Created by lihuiyan on 2016/6/7.
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long getId() {
        return id;
    }

    public String toString() {
        return "CountedObject  " + id;
    }
}
