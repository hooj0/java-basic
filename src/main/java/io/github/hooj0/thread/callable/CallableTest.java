package io.github.hooj0.thread.callable;

import java.util.concurrent.FutureTask;

/**
 * Callable示例
 *
 * @author hoojo
 * @version 1.0
 * @createDate Nov 7, 2010 3:05:45 PM
 * @file CallableTest.java
 * @package com.hoo.thread.callable
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 */
public class CallableTest {

    public static void main(String[] args) throws Exception {
        //创建Callable实现类的示例
        CallableThread ct = new CallableThread();
        //用FutureTask包装Callable对象
        FutureTask<Integer> ft = new FutureTask<>(ct);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 变量 i：" + i);
            if (i == 20) {
                //将FutureTask作为Thread的target对象，并起动线程
                new Thread(ft, "带返回值线程").start();
            }
        }
        System.out.println("结果：" + ft.get());
        //在线程类中sleep 200毫秒就会出现延时异常：java.util.concurrent.TimeoutException
        //System.out.println("200毫秒返回结果：" + ft.get(20, TimeUnit.MILLISECONDS));
        System.out.println("阻塞时，这里不被执行……");
    }
}
/**
 * 如果call方法启动后，FutureTask对象在调用get方法，在指定时间内没有得到返回值
 * 将会导致TimeoutException异常，call方法允许抛出异常，在用get方法获得返回值的时候
 * 会导致线程阻塞，直到获得返回值或出现TimeoutException异常才会取消阻塞
 */
