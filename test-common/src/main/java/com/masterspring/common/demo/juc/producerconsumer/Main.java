package com.masterspring.common.demo.juc.producerconsumer;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Consumer consumer = new Consumer(depot);
        producer.producer(50);
        producer.producer(80);
        consumer.consumer(20);
        consumer.consumer(100);
    }
}
