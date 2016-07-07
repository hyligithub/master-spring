package com.masterspring.common.performance.concurrent.future.jdkfuture;

import java.util.concurrent.*;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("aa"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(futureTask);
        try {
            System.out.println("这里可以做其他的业务");
            Thread.sleep(2000);//这里可以做其他的业务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(futureTask.get());
    }
}
