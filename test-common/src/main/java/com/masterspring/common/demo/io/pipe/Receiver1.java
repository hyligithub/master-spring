package com.masterspring.common.demo.io.pipe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;

public class Receiver1 extends Thread {

	private PipedInputStream pis;
	private File file;

	// 构造方法
	Receiver1(PipedInputStream pis, String fileName) {
		this.pis = pis;
		file = new File(fileName);
	}

	// 线程运行
	public void run() {
		try {
			// 写文件流对象
			FileOutputStream fs = new FileOutputStream(file);
			int data;
			// 从管道末端读
			while ((data = pis.read()) != -1) {
				// 写入本地文件
				fs.write(data);
			}
			pis.close();
		} catch (IOException e) {
			System.out.println("Receiver Error" + e);
		}
	}
}