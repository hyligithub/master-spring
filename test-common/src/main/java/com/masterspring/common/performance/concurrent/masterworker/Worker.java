package com.masterspring.common.performance.concurrent.masterworker;

import java.util.Map;
import java.util.Observable;
import java.util.Queue;

/**
 * Created by lihuiyan on 2016/2/17.
 */
public class Worker implements Runnable {

    protected Queue<Object> workeQueue;

    protected Map<String, Object> resultMap;

    public void setWorkeQueue(Queue<Object> queue) {
        this.workeQueue = queue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            Object o = workeQueue.poll();
            if (o == null) break;
            Object result = handle(o);
            resultMap.put(Integer.toString(o.hashCode()), result);
        }
    }
}
