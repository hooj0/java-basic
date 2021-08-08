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
public class ReaderThread extends Thread {

    //private PipedReader pr;
    /** 创建包装管道流的Buffer对象 */
    private final BufferedReader br;

    public ReaderThread(PipedReader pr) {
        //this.pr = pr;
        this.br = new BufferedReader(pr);
    }

    @Override
    public void run() {
        String bf = null;
        try {
            while ((bf = this.br.readLine()) != null) {
                System.out.println(bf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.br != null) {
                    this.br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
