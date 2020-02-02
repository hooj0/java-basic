package io.github.hooj0.classloader.proxy.example;

/**
 * 黛米·沃尔夫
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:50:11
 */
public class DemiWolf implements Dog {

    @Override
    public void info() {
        System.out.println("I‘m is a dog！");
    }

    @Override
    public void run() {
        System.out.println("I'm is run！！");
    }
}
