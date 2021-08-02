package io.github.hooj0.thread.group;

import io.github.hooj0.BasedTests;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 自定义异常处理程序
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/01/26 15:02:20
 */
public class CustomExceptionHandler extends BasedTests implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        out(t.getName() + " 发生异常：" + e + "\n" + e.getMessage());
    }

    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new CustomExceptionHandler());
        @SuppressWarnings("unused")
        int a = 5 / 0;
    }
}
