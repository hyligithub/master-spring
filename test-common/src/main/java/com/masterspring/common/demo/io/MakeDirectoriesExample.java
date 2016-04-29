package com.masterspring.common.demo.io;

import java.io.*;

/**
 * <p>
 * Title: JAVA进阶诀窍
 * </p>
 * 
 * 张峰 1.0
 */
public class MakeDirectoriesExample {
	private static void fileattrib(File f) {
		System.out.println("绝对路径: " + f.getAbsolutePath() + "可读属性: "
				+ f.canRead() + "可定属性: " + f.canWrite() + "文件名: " + f.getName()
				+ "父目录: " + f.getParent() + "当前路径: " + f.getPath() + "文件长度: "
				+ f.length() + "最后更新日期: " + f.lastModified());
		if (f.isFile()) {
			System.out.println("输入的是一个文件");
		} else if (f.isDirectory()) {
			System.out.println("输入的是一个目录");
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			args = new String[3];
		}
		args[0] = "d";
		args[1] = "test1.txt";
		args[2] = "test2.txt";
		File old = new File(args[1]), rname = new File(args[2]);
		old.renameTo(rname);
		fileattrib(old);
		fileattrib(rname);
		int count = 0;
		boolean del = false;
		if (args[0].equals("d")) {
			count++;
			del = true;
		}
		count--;
		while (++count < args.length) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + " 文件己经存在");
				if (del) {
					System.out.println("删除文件" + f);
					f.delete();
				}
			} else { // 如果文件不存在
				if (!del) {
					f.mkdirs();
					System.out.println("创建文件： " + f);
				}
			}
			fileattrib(f);
		}
	}
}