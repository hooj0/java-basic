package io.github.hooj0.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 14:53:43
 */
@SuppressWarnings("ALL")
public class ThreadPoolTest {

    /**
     * @param args
     * @author hoojo
     * @createDate Nov 7, 2010 4:51:28 PM
     */
    public static void main(String[] args) {
        //创建一个具有固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);

        //向线程池中提交2个线程
        pool.submit(new RunnableThread());
        pool.submit(new RunnableThread());

        //关闭线程池
        pool.shutdown();
    }
}
