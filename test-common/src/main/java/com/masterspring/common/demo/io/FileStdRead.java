package com.masterspring.common.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class FileStdRead implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int staticVar = 5;
	
	public static void main(String[] args) throws IOException {
				
		try {
			//初始时staticVar为5
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("result.obj"));
			out.writeObject(new FileStdRead());
			out.close();

			//序列化后修改为10
			FileStdRead.staticVar = 10;

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
					"result.obj"));
			FileStdRead t = (FileStdRead) oin.readObject();
			oin.close();
			
			//再读取，通过t.staticVar打印新的值
			System.out.println(t.staticVar);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
//		int b = 0;
//		char c = ' ';
//		System.out.println("请输入：");
//		while (c != 'q') {
//			int a = System.in.read();
//			c = (char) a;
//			b++;
//			System.out.println((char) a);
//		}
//		System.err.print("counted    " + b + "    totalbytes.");
//	}

}
// 读取输入的数据,直到数据中有Q这个字母然   