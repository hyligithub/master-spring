package com.masterspring.common.demo.concurrent.nio.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FilmServerNewThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilmServerNewThread fsnt = new FilmServerNewThread();
		try {
			fsnt.server();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void server() throws IOException {
		// 0.建立服务端socket链接
		ServerSocket ss = new ServerSocket(9999);

		while (true) {
			// 1.打开socket链接，等待客户端请求
			final Socket server = ss.accept();

			System.out.println("服务请求开始start");

			// 2.打开socket流信息，准备下面的操作
			final InputStream is = server.getInputStream();
			byte[] b = new byte[1024];

			int readCount = is.read(b);// 將客户端的请求信息(文件名)读入字节数组

			String str = new String(b);
			str = str.trim();
			final String serverFileName = str;
			// 3.对流信息进行读、写操作
			System.out.println("客户端读过来的信息是：" + str);

			if (readCount > 0) {
				new Thread() {
					public void run() {
						System.out.println("线程"
								+ Thread.currentThread().getName() + "启动");
						try {
							FileInputStream fs = new FileInputStream(
									serverFileName);
							// 3.1服務器回复客户端信息
							OutputStream os = server.getOutputStream();
							byte[] bfile = new byte[1024];
							while (fs.read(bfile) > 0) {
								os.write(bfile);
							}
							fs.close();
							os.close();

							// 4.关闭socket
							is.close();
							server.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}.start();
			}
		}
	}
}
