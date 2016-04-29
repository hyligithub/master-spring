package com.masterspring.common.demo.enums;

public enum RedisKeyEnum {

	// erpOrderId对应的orderId
	ERPORDERID_TO_ORDERID("erpOrderId_to_orderId_%s", (60 * 60 * 24) * 30),

	// add by lihy 20140911 投注worker执行时间点---------------------------
	/*
	 * 彩种投注worker执行时间点
	 */
	JD_LOTTERY_CACHE_BETTING_PREFIX("JD_LOTTERY_CACHE_BETTING_PREFIX_%s",
			(60 * 60 * 24) * 3),
	// 投注worker存活检测前缀
	CREATE_LOTTERY_BET_TASK_MSG("CP-CREATE-LOTTERY-BET-MESSAGE_%s",
			(60 * 60 * 24) * 1), //
	// add by lihy 投注配额前缀
	JD_LOTTERY_CACHE_BETTING_AMOUNT_PREFIX(
			"JD_LOTTERY_CACHE_BETTING_AMOUNT_PREFIX_%s_%s", (60 * 60 * 24) * 1);

	private String format;
	// 单位：秒
	private int exp;

	private RedisKeyEnum(String format, int exp) {
		this.format = format;
		this.exp = exp;
	}

	public String format(Object... values) {
		return String.format(format, values);
	}

	public int getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return "RedisKeyEnum{" + "format='" + format + '\'' + ", exp=" + exp
				+ '}';
	}

	public static void main(String args[]) {
		String sss = RedisKeyEnum.JD_LOTTERY_CACHE_BETTING_AMOUNT_PREFIX
				.format("aaa", "bbb");
		System.out.println(sss);
	}
}
