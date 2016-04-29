package com.masterspring.common.demo.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by lihuiyan on 2016/2/2.
 */
public class TestBuffer {

    public static void main(String[] args) {
        testBuffer();
    }

    private static void testBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        System.out.println(byteBuffer.limit() + "---" + byteBuffer.position() + "---" + byteBuffer.capacity());
        for(int i = 0;i<10;i++){
            byteBuffer.put((byte)i);
        }
        System.out.println(byteBuffer.limit() + "---" + byteBuffer.position() + "---" + byteBuffer.capacity());
        byteBuffer.flip();
        System.out.println(byteBuffer.limit() + "---" + byteBuffer.position() + "---" + byteBuffer.capacity());
        for(int i = 0;i<5;i++){
            System.out.println(byteBuffer.get());
        }
        System.out.println();
        System.out.println(byteBuffer.limit() + "---" + byteBuffer.position() + "---" + byteBuffer.capacity());
        byteBuffer.flip();
        System.out.println(byteBuffer.limit() + "---" + byteBuffer.position() + "---" + byteBuffer.capacity());
    }
}
