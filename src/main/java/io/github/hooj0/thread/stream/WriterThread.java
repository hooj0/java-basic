package io.github.hooj0.thread.stream;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * 线程输出流
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 6, 2010 6:49:53 PM
 * @file WriterThread.java
 * @package com.hoo.thread.stream
 * @project JavaThread
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class WriterThread extends Thread {

    private final String[] books = {
            "a",
            "b",
            "c"
    };

    private final PipedWriter pw;

    public WriterThread(PipedWriter pw) {
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                this.pw.write(this.books[i % 4] + "\n");
            }
        } catch (Exception ignored) {

        } finally {
            if (this.pw != null) {
                try {
                    this.pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
