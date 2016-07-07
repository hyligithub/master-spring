package com.masterspring.common.generic;

import com.masterspring.common.PrintUtil;

import java.util.ArrayList;
import java.util.Random;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by lihuiyan on 2016/6/6.
 */
public class RandomList2<T> {
    private ArrayList<T> storage = new ArrayList<T>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList2<Integer> r2 = new RandomList2<Integer>();
        for (int i = 0; i < 5; i++) {
            r2.storage.add(i);
        }
        PrintUtil.print(r2.select());
    }
}
