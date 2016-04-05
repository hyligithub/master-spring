package com.masterspring.common.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2016/4/5.
 */
public class AtomicIntegerWithLock {

    private int value;
    private Lock lock = new ReentrantLock();

    public AtomicIntegerWithLock() {
        super();
    }

    public AtomicIntegerWithLock(int value) {
        this.value = value;
    }

    public final int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    public final void set(int value) {
        lock.lock();
        try {
            this.value = value;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndSet(int newValue) {
        lock.lock();
        int oldValue;
        try {
            oldValue = value;
            value = newValue;
            return oldValue;
        } finally {
            lock.unlock();
        }
    }

    public final boolean compareAndSet(int expect, int update) {
        lock.lock();
        try {
            if (value == expect) {
                value = update;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndIncrement() {
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndDecrement() {
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }

    public final int decrementAndGet() {
        lock.lock();
        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet() {
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    public String toString() {
        return Integer.toString(value);
    }
}
