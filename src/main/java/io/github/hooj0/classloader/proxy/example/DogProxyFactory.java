package io.github.hooj0.classloader.proxy.example;

import java.lang.reflect.Proxy;

/**
 * 狗代理工厂
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:51:47
 */
public class DogProxyFactory {

    public static Object getProxy(Object target) {
        DogInvocationHandler handler = new DogInvocationHandler();
        handler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
