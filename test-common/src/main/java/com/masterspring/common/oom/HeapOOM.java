package com.masterspring.common.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2015/5/20.
 * VM args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
