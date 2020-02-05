package io.github.hooj0.classloader.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 狗调用处理程序
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 09:50:53
 */
public class DogInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogAspectj apj = new DogAspectj();

        //小狗吃东西
        apj.feed();
        Object result = method.invoke(this.target, args);
        apj.game();

        return result;
    }
}
