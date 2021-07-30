package io.github.hooj0.classloader.proxy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DogInvocationHandler implements InvocationHandler {

	private Object target;
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		DogAspectj apj = new DogAspectj();
		//小狗吃东西
		apj.feed();
		Object result = method.invoke(target, args);
		apj.game();
		return result;
	}
}
