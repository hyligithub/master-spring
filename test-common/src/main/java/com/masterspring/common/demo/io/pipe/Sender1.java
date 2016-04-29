package com.masterspring.common.demo.io.pipe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender1 extends Thread {

	private PipedOutputStream pos;

	private File file;

	// 构造方法
	Sender1(PipedOutputStream pos, String fileName) {
		this.pos = pos;
		file = new File(fileName);
	}

	// 线程运行方法
	public void run() {
		try {
			// 读文件内容
			FileInputStream fs = new FileInputStream(file);
			int data;
			while ((data = fs.read()) != -1) {
				// 写入管道始端
				pos.write(data);
			}
			pos.close();
		} catch (IOException e) {
			System.out.println("Sender Error" + e);
		}
	}
}