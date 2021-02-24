package io.github.hooj0.generic.generictype.confine;

public class ChildClass<T, F, B, A> implements ParentInterface<A, B> {
	private T t;//String
	private F f;//Boolean
	private A a;//Float
	private B b;//Integer
	
	public B getFoo() {
		return this.b;
	}

	public A getToo() {
		return this.a;
	}

	public void setFoo(B foo) {
		System.out.println("B:" + foo.getClass());
		this.b = foo;
	}

	public void setToo(A too) {
		System.out.println("A:" + too.getClass());
		this.a = too;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		System.out.println("t:" + t.getClass());
		this.t = t;
	}

	public F getF() {
		return f;
	}

	public void setF(F f) {
		System.out.println("f:" + f.getClass());
		this.f = f; 
	}
	
	public static void main(String[] args) {
		ChildClass<String, Boolean, Integer, Float> c = new ChildClass<String, Boolean, Integer, Float>();
		c.setF(true);
		Boolean b = c.getF();
		c.setT("abc");
		String t = c.getT();
		c.setFoo(2);
		Integer foo = c.getFoo();
		c.setToo(2f);
		Float too = c.getToo();
	}
}
