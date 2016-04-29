package com.masterspring.common.demo.suanfa.linkstack;

/**
 * @author lihy 通过链表实现栈操作
 */
public class LinkStack {
	private StackNode top;

	public StackNode push(StackNode sn) {
		sn.next = top;
		top = sn;
		return top;
	}

	public StackNode pop() {
		StackNode tmp;
		if (!isEmpty()) {
			tmp = top;
			top = top.next;
			return tmp;
		}
		return null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = new String[] { "1", "2", "3" };
		StackNode sn;
		LinkStack ls = new LinkStack();
		for (String s : a) {
			sn = new StackNode();
			sn.data = s;
			ls.push(sn);
		}
		while (ls.top != null) {
			String tmp = ls.pop().data;
			System.out.println(tmp);
		}
	}

}
