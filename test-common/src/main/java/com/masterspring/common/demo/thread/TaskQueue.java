package com.masterspring.common.demo.thread;

import java.util.LinkedList;
import java.util.List;


public class TaskQueue {

    private List<Task> queue = new LinkedList<Task>();

    public synchronized void addTask(Task task) {
        if (task != null) {
            queue.add(task);
        }
    }

    public synchronized void finishTask(Task task) {
        if (task != null) {
            task.setState(Task.State.FINISHED);
            queue.remove(task);
        }
    }

    /**
     * 取得一项待执行的任务
     *
     * @return
     */
    public synchronized Task getTask() {
        for (Task task : queue) {
            if (Task.State.NEW.equals(task.getState())) {
                task.setState(Task.State.RUNNING);
                return task;
            }
        }
//		Iterator<Task> it = queue.iterator();
//		Task task;
//		while (it.hasNext()) {
//			task = it.next();
//			//寻找一个新建的任务
//			if (Task.State.NEW.equals(task.getState())) {
//				//将任务的状态设置为进行中
//				task.setState(State.RUNNING);
//				return task;
//			}
//		}
        return null;
    }
}
