package com.masterspring.common.generic.demo.demo1;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 */
public class Notepad<K, V> {
    private K key;
    private V value;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}

class Demo2 {
    public static void main(String[] args) {
        Notepad<String, Integer> notepad = new Notepad<String, Integer>();
        notepad.setKey("jim");
        notepad.setValue(20);
        PrintUtil.print(notepad.getKey());
        PrintUtil.print(notepad.getValue());
    }
}
