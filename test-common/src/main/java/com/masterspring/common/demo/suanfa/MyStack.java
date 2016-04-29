package com.masterspring.common.demo.suanfa;

/**
 * @author lihy
 *数组实现栈，栈的特性是后进先出，只能从栈顶操作数据
 * @param <T>
 */
public class MyStack<T> {

	private Object[] array = null;
	private int capality;
	private final int defaultSize = 10;
	private int size;
	private int top = -1;

	public MyStack() {
		this.capality = this.defaultSize;
		array = new Object[capality];
		this.size = 0;

	}

	public MyStack(int capality) {
		this.capality = capality;
		array = new Object[capality];
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int size() {
		return this.size;
	}

	public void push(T obj) {
		if (this.size < this.capality) {
			this.top++;
			array[top] = obj;
			size++;
		} else {
			enableCapality();
			push(obj);

		}
	}

	public T pop() {
		if (isEmpty()) {
			try {
				System.out.println("栈为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		T temp = (T) array[this.top];
		array[top] = null;
		this.top--;
		this.size--;

		return temp;
	}

	public void enableCapality() {
		this.capality = this.capality * 2;
		Object[] newarray = new Object[this.capality];
		System.arraycopy(array, 0, newarray, 0, size);
		this.array = newarray;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<Integer> mystack = new MyStack();
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		while (!mystack.isEmpty()) {
			System.out.println(mystack.pop());
		}
	}

}
