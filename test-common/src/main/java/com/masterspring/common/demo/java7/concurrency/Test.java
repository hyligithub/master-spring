package com.masterspring.common.demo.java7.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	private List<String> list = Collections.EMPTY_LIST;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public static void main(String[] args) {
		User user = new User();
		new Test().execute(user);
		new Test().printList(user);
		
	}

	private void execute(User user) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfo u1 = new UserInfo("zhangsan", "1");
		UserInfo u2 = new UserInfo("lisi", "2");
		user.getUserInfo().add(u1);
		user.getUserInfo().add(u2);
//		list.add(u1);
//		list.add(u2);
//		user.setUserInfo(list);
//		int num = user.getUserInfo().size();
		
//		for(UserInfo u : user.getUserInfo()){
//			System.out.println(u.getName());
//		}
//		System.out.println(num);

	}
	
	private void printList(User user){
		for(UserInfo u:user.getUserInfo()){
			System.out.println(u.getName());
		}
	}

}
