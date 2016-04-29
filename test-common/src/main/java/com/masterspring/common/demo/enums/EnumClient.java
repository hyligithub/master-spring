package com.masterspring.common.demo.enums;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EnumClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("127.0.0.1", 8999));// 建立到服务器的链接
			OutputStream os = socket.getOutputStream();// 从连接得到输出流
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(WeekDayEnum.Fri);
			oos.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
