package io.github.hooj0.thread.stream;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 应用程序
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 15:06:11
 */
public class StreamApp {

    public static void main(String[] args) {
        PipedWriter pw = null;
        PipedReader pr = null;

        try {
            pw = new PipedWriter();
            pr = new PipedReader();

            //连接管道输入输出流
            pw.connect(pr);

            //将连接好的输入、输出流分别传入线程
            new ReaderThread(pr).start();
            //就可以让2个线程通过管道流通信
            new WriterThread(pw).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
