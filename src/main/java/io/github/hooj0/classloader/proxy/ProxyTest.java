package io.github.hooj0.classloader.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		InvocationHandler handler = new MyInvokationHandler();
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
	public void walk() {
		System.out.println("walk……");
	}
	
	public void say(String name) {
		System.out.println(name + "say....");
	}
}
