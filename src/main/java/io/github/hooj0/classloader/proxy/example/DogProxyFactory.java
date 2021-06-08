package io.github.hooj0.classloader.proxy.example;

import java.lang.reflect.Proxy;

public class DogProxyFactory {
	public static Object getProxy(Object target) {
		DogInvocationHandler handler = new DogInvocationHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
