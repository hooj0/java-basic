package io.github.hooj0.classloader.classInit;

@SuppressWarnings("ALL")
public class ClassB extends ClassA {
	public ClassB () {
		System.out.println("############init ClassB");
	}
	static {
		System.out.println("ClassB 静态块一");
	}
}
