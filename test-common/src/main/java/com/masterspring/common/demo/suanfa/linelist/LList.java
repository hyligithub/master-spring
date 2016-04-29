package com.masterspring.common.demo.suanfa.linelist;

/**
 * @author lihy
 * 
 * @线性表接口定义
 * @param <E>
 */
public interface LList<E>{
	public boolean isEmpty();//是否为空，为空返回true
	int length();//长度
	E get(int index);//返回索引index的对象，index初始值为0
	E set(int index, E element);//在索引index处放element,返回原对象
	boolean add(int index, E element);//插入element,插入后序号为index
	E remove(int index);//移除序号为Index的对象
	void clear();//清空线性表
}
