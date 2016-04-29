package com.masterspring.common.demo.io.pipe;

import java.io.PipedWriter;
import java.util.Random;

/**
 * @author lihy
 *PipedInputStream/PipedOutputStream（管道输入输出）

（1）它用于实现管道的二进制格式的输入输出（将一个线程的输出结果直接连接到另一个线程的输入端口，实现两者数据直接传送）。
（2） PipedReader/PipedWriter类：它用于实现管道的字符格式的输入输出。
（3）要求：操作时需要将两个端口相互连结。
（4）实现原理：
（5） 管道的连接：
方法一：是通过构造函数直接将某一个程序的输出作为另一个程序的输入，在定义对象时指明目标管道对象

方法二：是利用双方类中的任一个成员函数 connect()相连接
（6）实例讲解： Sender.java, Receiver.java, PipedIO.java （使用PipedWriter,PipedReader）
 */
class Sender extends Thread {
	private Random rand = new Random();
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter() {
		return out;
	}

	public void run() {
		while (true) {
			for (char c = 'A'; c <= 'z'; c++) {
				try {
					out.write(c);
					sleep(rand.nextInt(500));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}