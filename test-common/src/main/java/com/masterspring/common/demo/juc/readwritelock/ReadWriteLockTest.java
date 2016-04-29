package com.masterspring.common.demo.juc.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lihuiyan on 2015/5/6.
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        UserCount userCount = new UserCount("123456", 10000);
        User user = new User("����", userCount);
        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash((i + 1) * 1000);
        }
    }
}

class User {
    private String name;
    private UserCount userCount;
    private ReadWriteLock readWriteLock;

    public User(String name, UserCount userCount) {
        this.name = name;
        this.userCount = userCount;
        readWriteLock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread() {
            public void run() {
                readWriteLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " getCash start");
                    userCount.getCash();
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " getCash end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.readLock().unlock();
                }
            }
        }.start();
    }

    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                readWriteLock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " setCash start");
                    userCount.setCash(cash);
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " setCash end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }
        }.start();
    }
};

class UserCount {
    private String id;
    private int cash;

    public UserCount(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        System.out.println(Thread.currentThread().getName() +" getCash cash="+ cash);
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
};
