package com.masterspring.common.demo.collection.testtreemap;

public class M implements Comparable {
	int count;

	public M(int count) {
		this.count = count;
	}

	public String toString() {
		return "M(count属性:" + count + ")";
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o.getClass() == M.class) {
			M m = (M) o;
			if (m.count == this.count) {
				return true;
			}
		}
		return false;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		M m = (M) o;

		if (m.count == this.count) {
			return 0;
		} else if (this.count > m.count) {
			return 1;
		} else {
			return -1;
		}

	}

}
