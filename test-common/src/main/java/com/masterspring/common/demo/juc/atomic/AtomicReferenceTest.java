package com.masterspring.common.demo.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lihuiyan on 2015/5/4.
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        Person person1 = new Person(101);
        Person person2 = new Person(102);
        AtomicReference atomicReference = new AtomicReference(person1);
        atomicReference.compareAndSet(person1, person2);
        Person person3 = (Person) atomicReference.get();
        System.out.println("p3 is = " + person3);
        System.out.println("p3.equals(p1)=" + person3.equals(person1));

    }

}

class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public boolean equals(Person person) {
        return person.id == this.id;
    }

    public String toString() {
        return "id:" + id;
    }

}
