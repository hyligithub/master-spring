package com.masterspring.common.demo.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileRW {

	public static void main(String args[]) {
		StringBuffer buf = new StringBuffer();
		char ch;

		try {
			while ((ch = (char) System.in.read()) != '\n') {
				buf.append(ch);
			}

			// 读写方式可以为"r" or "rw"

			/**
			 * @param mode
			 *            1. r 2. rw 3. rws 4. rwd "r" Open for reading only.
			 *            Invoking any of the write methods of the resulting
			 *            object will cause an IOException to be thrown. "rw"
			 *            Open for reading and writing. If the file does not
			 *            already exist then an attempt will be made to create
			 *            it. "rws" Open for reading and writing, as with "rw",
			 *            and also require that every update to the file's
			 *            content or metadata be written synchronously to the
			 *            underlying storage device. "rwd" Open for reading and
			 *            writing, as with "rw", and also require that every
			 *            update to the file's content be written synchronously
			 *            to the underlying storage device.
			 */
			RandomAccessFile myFileStream = new RandomAccessFile(
					"c:\\UserInput.txt", "rw");
			myFileStream.seek(myFileStream.length());
			myFileStream.writeBytes(buf.toString());

			// 将用户从键盘输入的内容添加到文件的尾部
			myFileStream.close();
		} catch (IOException e) {
		}
	}
}