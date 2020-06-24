package io.github.hooj0.classloader.classInit;

/**
 * classb
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:09:42
 */
@SuppressWarnings("ALL")
public class ClassB extends ClassA {
    public ClassB() {
        System.out.println("############init ClassB");
    }

    static {
        System.out.println("ClassB 静态块一");
    }
}
