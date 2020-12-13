package io.github.hooj0.classloader.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:52:58
 */
public class ProxyTest {

    public static void main(String[] args) {
        InvocationHandler handler = new MyInvocationHandler();
        IPerson p = (IPerson) Proxy.newProxyInstance(Person.class.getClassLoader(), Person.class.getInterfaces(), handler);
        p.walk();
        p.say("abc");
    }
}

interface IPerson {
    public void walk();

    public void say(String name);
}

class Person implements IPerson {
    @Override
    public void walk() {
        System.out.println("walk……");
    }

    @Override
    public void say(String name) {
        System.out.println(name + "say....");
    }
}
