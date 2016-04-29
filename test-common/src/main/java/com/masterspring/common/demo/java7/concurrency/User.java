package com.masterspring.common.demo.java7.concurrency;

import java.util.Collections;
import java.util.List;

public class User {

	private List<UserInfo> userInfo = Collections.EMPTY_LIST;

	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}

}
