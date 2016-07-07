package com.masterspring.common.performance.concurrent.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadFactory;

/**
 * Created by lihuiyan on 2016/2/17.
 */
public class Master {
    //任务队列
    protected Queue<Object> workeQueue = new ConcurrentLinkedQueue<Object>();
    //工作线程
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
    //子任务处理结果
    protected Map<String, Object> resultMap = new HashMap<String, Object>();

    //检查所有线程是否都已经执行完成
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED)
                return false;
        }
        return false;
    }

    //构造上下文
    public Master(Worker worker, int countWorker) {
        worker.setResultMap(resultMap);
        worker.setWorkeQueue(workeQueue);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    //提交一个任务
    public void submit(Object object) {
        workeQueue.add(object);
    }

    //返回执行结果集
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    //开始执行任务
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}
