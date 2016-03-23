package com.masterspring.common.generic.generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class CoffeGenerator implements Generator<Coffe> {

    private Class[] types = {Mocha.class, Breve.class, Latte.class};
    private static Random random = new Random(47);

    public CoffeGenerator() {
    }

    private int size;

    public CoffeGenerator(int size) {
        this.size = size;
    }


    @Override
    public Coffe next() {
        try {
            return (Coffe) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CoffeGenerator gen = new CoffeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

    }
}
