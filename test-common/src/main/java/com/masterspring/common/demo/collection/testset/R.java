package com.masterspring.common.demo.collection.testset;

public class R {
    int count;

    public R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R(count属性)：" + count + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof R) {
            R r = (R) o;
            if (r.count == this.count) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.count;
    }
}
