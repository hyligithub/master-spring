package com.masterspring.common.oom.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2015/5/23.
 * �ڴ�ռλ������һ��OOMObject��Լռ64KB
 * Xms:100M,Xmx:100M
 * VM args:-Xms100m -Xmx100m -XX:+HeapDumpOnOutOfMemoryError
 */
public class JconsoleTest1 {
    public static void main(String[] args) {
        fillHeap(1000);
        System.gc();
    }

    private static void fillHeap(int num) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new OOMObject());
        }

    }
}

class OOMObject {
    public byte[] placeHolder = new byte[64 * 1024];
}

