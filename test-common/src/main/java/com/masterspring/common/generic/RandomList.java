package com.masterspring.common.generic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random random = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<String>();
        for (String ss : "JD AaLi Baidu Amazon".split(" ")) {
            randomList.add(ss);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(randomList.select());
        }
    }
}
