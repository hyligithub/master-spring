package com.masterspring.common.demo.io.inandoutstream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by lihuiyan on 2015/5/21.
 */
public class ByteArrayOutputStreamTest {
    private static final int LEN = 5;
    // ��ӦӢ����ĸ��abcdefghijklmnopqrsttuvwxyz��
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        testOutputStream();
    }

    private static void testOutputStream() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(0x41);
        bos.write(0x42);
        bos.write(0x43);
        System.out.println(bos.toString());
        //arrayLetters�����дӵ�3��λ�ÿ�ʼ��д��5���ֽڵ������
        bos.write(ArrayLetters, 3, 5);
        System.out.printf("bos = %s\n", bos);

        int size = bos.size();
        System.out.println(size);

        //ת�����ַ�����
        byte[] buf = bos.toByteArray();
        String s = new String(buf);

        System.out.printf("s = %s\n", s);

        //��bosд�뵽��һ�������
        try {
            ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
            bos.writeTo(bos2);
            System.out.printf("bos2 = %s\n", bos2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
