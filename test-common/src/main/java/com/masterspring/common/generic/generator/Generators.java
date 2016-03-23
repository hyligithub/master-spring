package com.masterspring.common.generic.generator;


import java.util.*;

/**
 * Created by lihuiyan on 2016/3/18.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(gen.next());
        }
        return collection;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        {
            for (int i = 0; i < n;
                 i++) {
                list.add(gen.next());

            }
            return list;
        }
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            set.add(gen.next());
        }
        return set;
    }

    public static void main(String[] args) {
//        Collection<Coffe> collection = fill(new ArrayList<Coffe>(), new CoffeGenerator(), 4);
//        for (Coffe coffe : collection) {
//            System.out.println(coffe);
//        }
//
//        List<Coffe> ll = fill(new ArrayList<Coffe>(), new CoffeGenerator(), 4);
//        for (Coffe coffe : ll) {
//            System.out.println(coffe);
//        }

        Set<Coffe> set = fill(new HashSet<Coffe>(), new CoffeGenerator(), 4);
        Iterator<Coffe> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
