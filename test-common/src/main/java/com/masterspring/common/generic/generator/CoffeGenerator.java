package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class CoffeGenerator implements Generator<Coffe>, Iterable<Coffe> {

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

    class CoffeIterator implements Iterator<Coffe> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffe next() {
            count--;
            return CoffeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns an iterator over a set of elements of type T.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Coffe> iterator() {
        return new CoffeIterator();
    }


    public static void main(String[] args) {
        CoffeGenerator gen = new CoffeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class[] type11 = {Mocha.class, Breve.class, Latte.class};
        Coffe c = (Coffe)type11[0].newInstance();
        PrintUtil.print(c);

    }
}
