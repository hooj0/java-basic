package io.github.hooj0.classloader.classInit;

/**
 * 类装入器测试
 *
 * @author hoojo
 * @version 1.0
 * @date Sep 28, 2010 6:44:04 PM
 */
@SuppressWarnings("ALL")
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        //System.out.println(Tester.a);
        ClassLoader c = ClassLoader.getSystemClassLoader();
        System.out.println("加载Tester类……");

        //只加载Tester类，并不初始化
        c.loadClass("com.hoo.base.classInit.Tester");
        System.out.println("初始化Tester类……");

        //初始化Tester类
        Class.forName("com.hoo.base.classInit.Tester");
    }
}

class Tester {
    static {
        System.out.println("静态块被执行了吗……");
    }

    static int a = 10;
}
