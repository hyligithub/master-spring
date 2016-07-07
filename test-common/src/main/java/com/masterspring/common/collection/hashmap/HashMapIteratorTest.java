package com.masterspring.common.collection.hashmap;

import java.util.*;

/**
 * Created by lihuiyan on 2015/4/22.
 */
public class HashMapIteratorTest {

    public static void main(String[] args) {
        Random random = new Random();
        String key = null;
        Integer value;
        int val = 0;
        HashMap map = new HashMap();
        for (int i = 0; i < 100; i++) {
            val = random.nextInt(100);
            value = random.nextInt(5);
            map.put(String.valueOf(val), value);
        }

        iteratorByEntry(map);
        iteratorByKeySet(map);
        iteratorValues(map);
    }

    private static void iteratorByEntry(HashMap map) {
        if (map == null) {
            System.out.println("map is null");
            return;
        }
        String key = null;
        Integer value;
        long startTime = System.currentTimeMillis();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry e = (Map.Entry) iterator.next();
            key = (String) e.getKey();
            value = (Integer) e.getValue();
            System.out.println(key + "---" + value);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorByEntry interval:" + (endTime - startTime) + " ms");
    }

    private static void iteratorByKeySet(HashMap map) {
        if (map == null) {
            System.out.println("map is null");
            return;
        }
        String key = null;
        Integer value;
        long startTime = System.currentTimeMillis();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = (Integer) map.get(key);
            System.out.println(key + "---" + value);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorByKeySet interval:" + (endTime - startTime) + " ms");
    }

    private static void iteratorValues(HashMap map) {
        if (map == null) {
            System.out.println("map is null");
            return;
        }
        long startTime = System.currentTimeMillis();
        Collection c = map.values();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorValues interval:" + (endTime - startTime) + " ms");

    }
}
