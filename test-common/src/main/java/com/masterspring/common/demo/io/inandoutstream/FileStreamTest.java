package com.masterspring.common.demo.io.inandoutstream;

import java.io.*;

/**
 * Created by lihuiyan on 2015/5/22.
 * FileInputStream FileOutputStream���Գ���
 */
public class FileStreamTest {
    private static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {

        File file = new File(FILE_NAME);
        try {
            FileOutputStream out = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(out);
            printStream.print("adcde");
            printStream.close();

            FileOutputStream out2 = new FileOutputStream(file, true);
            PrintStream printStream1 = new PrintStream(out2);
            printStream1.println(123456);
            printStream1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            //���ַ�ʽ�����ļ�������
            FileInputStream in = new FileInputStream(new File(FILE_NAME));
            FileInputStream in1 = new FileInputStream(FILE_NAME);
            FileDescriptor fileDescriptor = in1.getFD();
            FileInputStream in2 = new FileInputStream(fileDescriptor);

            char c1 = (char) in.read();
            System.out.println(c1);

            in.skip(3);

            byte[] buf = new byte[10];
            in.read(buf, 0, buf.length);
            System.out.printf("buf=%s\n", new String(buf));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(in2);
            char c2 = (char) bufferedInputStream.read();
            System.out.println(c2);

            in.close();
            in1.close();
            in2.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
