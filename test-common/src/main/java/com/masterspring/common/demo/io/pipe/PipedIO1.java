package com.masterspring.common.demo.io.pipe;

import java.io.IOException;  
import java.io.PipedInputStream;  
import java.io.PipedOutputStream;  
  
public class PipedIO1 {  
  
    public static void main(String[] args) {  
        try {  
            // 构造读写的管道流对象  
            PipedInputStream pis = new PipedInputStream();  
            PipedOutputStream pos = new PipedOutputStream();  
              
            // 实现关联  
            pos.connect(pis);  
              
            // 构造两个线程，并且启动。  
            new Sender1(pos, "c:\\a1.txt").start();  
            new Receiver1(pis, "c:\\a2.txt").start();  
        } catch (IOException e) {  
            System.out.println("Pipe Error" + e);  
        }  
    }  
} 