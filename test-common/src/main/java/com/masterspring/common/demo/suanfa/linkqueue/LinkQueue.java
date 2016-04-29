package com.masterspring.common.demo.suanfa.linkqueue;

public class LinkQueue {

	private QueueNode front = null;
	private QueueNode rear = null;

	public Object push(QueueNode qn) {
		if (isEmpty()) {
			front = rear = qn;
		} else {
			rear.next = qn;
			rear = qn;
		}
		return qn;
	}

	public Object pop() {
		if (isEmpty()) {
			return null;
		} else {
			QueueNode qn;
			qn = front;
			front = front.next;
			if (qn == rear) {
				front = null;
			}
			return qn;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a[] = { "1", "2", "3" };
		LinkQueue lq = new LinkQueue();
		QueueNode qn = null;
		for (String s : a) {
			qn = new QueueNode();
			qn.data = s;
			lq.push(qn);
		}
		while (!lq.isEmpty()) {
			System.out.println(((QueueNode) lq.pop()).data);
		}

	}

}
