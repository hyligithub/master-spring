package com.masterspring.common.demo.suanfa.linelist;

/**
 * @author lihy 描述：通过数组实现线性表
 */
public class SeqList<E> implements LList<E> {

	private Object[] table;// 对象数据
	private int len;// 顺序表长度

	/**
	 * 初始化空线性表
	 */
	public SeqList() {

	}

	/**
	 * 初始化指定容量的线性表
	 * 
	 * @param capality
	 */
	public SeqList(int capality) {

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		if(index>=0&&index<this.len){
			E obj = (E)table[index];
			return obj;
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(int index, Object element) {
		// TODO Auto-generated method stub

		if (element == null) {
			try {
				throw new Exception("不能插入空值");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		if (index < 0) {
			return false;// 插入位置不对
		}
		if (index >= this.len)
			index = this.len;
		if (this.len == table.length) {// 数组满，扩容
			Object[] tmp = this.table;
			this.table = new Object[tmp.length * 2];
			for (int i = 0; i < tmp.length; i++) {
				table[i] = tmp[i];
			}
		}
		for (int j = len - 1; j >= index; j--) {
			table[j + 1] = table[j];
		}
		table[index] = element;
		this.len++;
		return true;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		if(this.len!=0&&index>=0&&index<this.len){
			E old = (E)table[index];
			
			for(int j=index;j<this.len-1;j++){
				table[j]=table[j+1];
			}
			this.table[len-1]=null;
			this.len--;
			return old;
		}
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
