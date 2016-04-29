package com.masterspring.common.demo.concurrent.nio.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FilmServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilmServer fs = new FilmServer();
		try {
			fs.server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 服务端响应请求
	 * 
	 * @throws IOException
	 */
	public void server() throws IOException {
		// 0.建立服务端server的socket
		ServerSocket ss = new ServerSocket(9999);

		while (true) {

			// 1.打开Socket链接，等待客户端请求
			final Socket server = ss.accept();

			System.out.println("服务---请求开始start");

			// 2.打开Socket流信息，准备下面的操作

			final InputStream is = server.getInputStream();
			byte b[] = new byte[1024];

			int readCount = is.read(b);

			String str = new String(b);
			str = str.trim();
			final String serverFileName = str;

			// 3.对流信息进行读、写操作
//			System.out.println("客户端读过来的信息是：" + str);
			System.out.println("线程启动：" + Thread.currentThread().getName());
			try {

				FileInputStream fs = new FileInputStream(serverFileName);

				// 3.1服务器回复客户端信息(response)
				OutputStream os = server.getOutputStream();
				byte[] bfile = new byte[1024];

				// 往客户端写
				while (fs.read(bfile) > 0) {
					os.write(bfile);
				}

				fs.close();
				os.close();

				// 4.关闭Socket
				// 先关闭输入流
				is.close();

				// 最后关闭Socket
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
