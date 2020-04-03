package io.github.hooj0.classloader.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * invokation处理程序
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:46:37
 */
public class MyInvokationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("当前执行的方法是：" + method);
        if (args != null) {
            for (Object o : args) {
                System.out.println(o);
            }
        }
        return null;
    }
}
