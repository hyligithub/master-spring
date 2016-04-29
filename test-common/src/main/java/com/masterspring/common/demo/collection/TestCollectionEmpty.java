package com.masterspring.common.demo.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionEmpty {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        testCollection();
    }

    private static void testCollection() {
        List<String> list = Collections.EMPTY_LIST;
        List<String> ll = new ArrayList();
        ll.add("1");
        ll.add("2");
        list = ll;
        for (String s : list) {
            System.out.println(s);
        }
    }

}
