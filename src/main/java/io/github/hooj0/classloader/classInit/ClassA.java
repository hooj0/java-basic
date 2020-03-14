package io.github.hooj0.classloader.classInit;

/**
 * classa
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:09:26
 */
@SuppressWarnings("ALL")
public class ClassA {
    static {
        System.out.println("ClassA 静态块一");
    }

    public ClassA() {
        System.out.println("init######ClassA");
    }

    static {
        System.out.println("ClassA 静态块二");
    }
}
