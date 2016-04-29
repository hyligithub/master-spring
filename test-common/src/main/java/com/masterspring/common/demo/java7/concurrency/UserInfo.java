package com.masterspring.common.demo.java7.concurrency;

public class UserInfo {
	private String name;
	private String male;

	public UserInfo(String name, String male) {
		this.name = name;
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}
}
