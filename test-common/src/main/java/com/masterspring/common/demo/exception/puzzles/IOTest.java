package com.masterspring.common.demo.exception.puzzles;

import java.io.*;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class IOTest {
    public static void main(String[] args) {

    }

    private static void copy(String source, String desc) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(desc);
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) > 0) {
                out.write(buff, 0, n);
            }
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {

                }
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                }
        }
    }
}
