package com.masterspring.common.demo.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by lihuiyan on 2016/2/2.
 */
public class NioCopyFiles {
    public static void main(String[] args) {
        try {
            nioCopyFile("d://a.txt", "d://b.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void nioCopyFile(String src, String desc) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int len = readChannel.read(byteBuffer);
            if (len == -1) {
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
        }
        fis.close();
        fos.close();

    }
}
