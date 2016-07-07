package com.masterspring.common.juc.atomic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * Created by lihuiyan on 2015/5/4.
 */
public class AtomicLongFieldUpdate {
    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz = Person1.class;
//        Field field = clazz.getDeclaredField("id");
//        field.setAccessible(true);
        AtomicLongFieldUpdater atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(clazz, "id");
        Person1 person1 = new Person1(12345678L);
        atomicLongFieldUpdater.compareAndSet(person1, 12345678L, 1000);
        System.out.println(person1.getId());
    }
}

class Person1 {
    volatile long id;

    public Person1(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
