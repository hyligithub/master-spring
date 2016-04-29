package com.masterspring.common.demo.concurrent.nio.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FilmClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 2; i++) {
			Client client = new FilmClient().new Client();
			client.i = i;
			client.start();
		}

	}

	class Client extends Thread {
		int i;

		public void run() {
			// 1.建立socket链接
			Socket client;
			try {
				client = new Socket("127.0.0.1", 9999);

				// 2.打开socket流信息，准备下面的操作
				OutputStream os = client.getOutputStream();

				// 3.写信息
				os.write("F://film.rmvb".getBytes());
				String fileName = "d://io." + i + ".rmvb";
				FileOutputStream fos = new FileOutputStream(fileName);
				// 3.1接收服务端反馈
				InputStream is = client.getInputStream();
				byte b[] = new byte[1024];
				while (is.read(b) > 0) {
					fos.write(b);
				}
				// 4.关闭socket
				// 先关闭输出流
				os.close();

				// 最后关闭socket
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
