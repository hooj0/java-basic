package io.github.hooj0.generic.generictype.confine;

public interface ParentInterface<T, F> {
	public void setToo(T too);
	public void setFoo(F foo);
	
	public T getToo();
	public F getFoo();
}
