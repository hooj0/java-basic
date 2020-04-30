package io.github.hooj0.classloader.instance;

import io.github.hooj0.BasedTests;

/**
 * 单体测试
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 4, 2010 4:16:07 PM
 */
public class SingletonTest extends BasedTests {

    private SingletonTest() {
        out("私有无参构造，其他类不能实例化 Me！");
    }

    {
        out("普通初始化块，execute……");
    }

    private static SingletonTest t;

    static {
        t = new SingletonTest();
        out("静态初始化块，只运行一次");
    }

    public static SingletonTest getInstance() {
        return t;
    }

    public static void main(String[] args) {
        out("#########1#########");
        SingletonTest t = new SingletonTest();
        out("#########2#########");
        SingletonTest t2 = new SingletonTest();
        out(t == t2);
        out("#########3#########");
        SingletonTest t3 = SingletonTest.getInstance();//执行一次，只有一个实例
        out(t3 == t2);
        out("#########4#########");
        SingletonTest t4 = SingletonTest.getInstance();
        out(t3 == t4);//指向同一个对象
    }
}
