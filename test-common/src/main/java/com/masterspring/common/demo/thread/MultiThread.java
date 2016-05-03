package com.masterspring.common.demo.thread;

import com.masterspring.common.PrintUtil;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by lihuiyan on 2016/5/3.
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            PrintUtil.print(threadInfo.getThreadId() + "---" + threadInfo.getThreadName());
        }
    }
}
