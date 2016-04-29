package com.masterspring.common.demo.enums;

public enum WeekDayEnum {

	Mon(1), Tue(2), Wed(3), Thu(4), Fri(5), Sat(6), Sun(7);

	private int index;

	private WeekDayEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

}
