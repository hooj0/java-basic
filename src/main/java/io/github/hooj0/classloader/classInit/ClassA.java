package io.github.hooj0.classloader.classInit;

@SuppressWarnings("ALL")
public class ClassA {
	static {
		System.out.println("ClassA 静态块一");
	}
	public ClassA() {
		System.out.println("init######ClassA");
	}
	static {
		System.out.println("ClassA 静态块二");
	}
}
