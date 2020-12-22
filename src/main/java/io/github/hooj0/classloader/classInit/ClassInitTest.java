package io.github.hooj0.classloader.classInit;

import io.github.hooj0.BasedTests;

/**
 * 类初始化测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:09:51
 */
@SuppressWarnings("ALL")
public class ClassInitTest extends BasedTests {

    // 声明一个变量，给初始值
    static int a = 5;
    static int b;
    static int c; // 默认初始值0

    static {
        // 用静态块为b赋值
        b = 6; // 变量b没有初始值，jvm默认赋值0；当执行静态块的时候，发现b是默认值0；再次初始化赋值6
        z = 22; // 只会赋初始值，因为z有初始值1，所以z = 22不能成功初始化。也就是说z已经初始化过
    }

    static int z = 1;

    public static void main(String[] args) {
        out(ClassInitTest.a);
        out(ClassInitTest.b);
        out(ClassInitTest.c);
        out(ClassInitTest.z);
    }
}
