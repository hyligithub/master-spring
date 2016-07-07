package com.masterspring.common.test;

import java.util.HashMap;

/**
 * Created by lihuiyan on 2016/6/21.
 */
public class TestHashCode {
    private String color;

    public TestHashCode(String color) {
        this.color = color;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof TestHashCode))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((TestHashCode) obj).color);
    }

    public int hashCode() {
        return this.color.hashCode();
    }

    public static void main(String[] args) {
        TestHashCode a1 = new TestHashCode("green");
        TestHashCode a2 = new TestHashCode("red");

        //hashMap stores apple type and its quantity
        HashMap<TestHashCode, Integer> m = new HashMap<TestHashCode, Integer>();
        m.put(a1, 10);
        m.put(a2, 20);
        System.out.println(m.get(new TestHashCode("green")));
    }
}
