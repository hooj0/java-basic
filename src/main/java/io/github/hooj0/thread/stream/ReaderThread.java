package io.github.hooj0.thread.stream;

import java.io.BufferedReader;
import java.io.PipedReader;

/**
 * 线程输入流
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 6, 2010 6:49:05 PM
 * @file ReaderThread.java
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
@SuppressWarnings("ALL")
public class ReaderThread extends Thread {

    // private PipedReader reader;
    /** 创建包装管道流的Buffer对象 */
    private final BufferedReader reader;

    public ReaderThread(PipedReader reader) {
        //this.reader = reader;
        this.reader = new BufferedReader(reader);
    }

    @Override
    public void run() {
        String bf = null;
        try {
            while ((bf = this.reader.readLine()) != null) {
                System.out.println(bf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.reader != null) {
                    this.reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
