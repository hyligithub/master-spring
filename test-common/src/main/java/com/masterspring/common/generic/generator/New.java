package com.masterspring.common.generic.generator;

import java.util.*;

/**
 * Created by lihuiyan on 2016/3/18.
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> LinkedList<T> llist() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String, String> map = New.map();
        List<String> list = New.list();
        Set<Integer> set = New.set();
        map.put("1","2");
    }
}
