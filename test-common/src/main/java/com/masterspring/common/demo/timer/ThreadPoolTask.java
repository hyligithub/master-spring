package com.masterspring.common.demo.timer;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 线程池执行的任务
 */
public class ThreadPoolTask implements Runnable, Serializable {

    /**
     * serialVersionUID, JDK1.5中，每个实现Serializable接口的类都推荐声明这样的一个ID
     */
    private static final long serialVersionUID = -2443443826296885045L;

    private static int consumeTaskSleepTime = 2000;

    private Object threadPoolTaskData;
    private List<String> tasks;

    private CountDownLatch end;
    private String msg;

    ThreadPoolTask(List<String> tasks, CountDownLatch end, String msg) {
        this.tasks = tasks;
        this.end = end;
        this.msg = msg;
    }

    // 每个任务的执行过程，现在是什么都没做，除了print和sleep，:)
    public void run() {
        System.out.println("start ..");
        try {
//			for (String task : tasks) {
//				System.out.println(task);
//			}
            System.out.println(msg + "-----------------------------------------");
            // 便于观察现象，等待一段时间
            Thread.sleep(consumeTaskSleepTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (end != null) {
                end.countDown();
            }
        }
    }

}