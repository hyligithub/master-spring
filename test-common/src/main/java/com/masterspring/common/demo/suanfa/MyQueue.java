package com.masterspring.common.demo.suanfa;

public class MyQueue {

	private Object[] array = null;
	private int front;
	private int rear;
	private int size;

	public MyQueue(int size) {
		this.size = size;
		array = new Object[size];
		this.front = 0;
		this.rear = 0;
	}

	public MyQueue() {
		this(10);
	}

	public void addQueue(Object obj) {
		if (isFull()) {
			try {
				throw new Exception("队列满");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			array[rear] = obj;
			rear=(rear+1)%size;
 
		}
	}

	public Object delQueue() {
		Object temp = null;
		if (isEmpty()) {
			try {
				throw new Exception("队列空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			temp = array[front];
			array[front] = null;
			front = (front + 1) % size;
			return temp;
		}
		return temp;
	}

	public boolean isFull() {
		if ((rear + 1) % size == front) {
			return true;
		} else
			return false;
	}

	public boolean isEmpty() {
		if (front == rear) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue(5);
		queue.addQueue(1);
		queue.addQueue(2);
		queue.addQueue(3);
		queue.addQueue(4);

		System.out.println(queue.delQueue());
		System.out.println(queue.delQueue());
		System.out.println(queue.delQueue());
		System.out.println(queue.delQueue());

	}

}
