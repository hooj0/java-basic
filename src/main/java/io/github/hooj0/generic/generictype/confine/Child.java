package io.github.hooj0.generic.generictype.confine;

public class Child<F, T, H>  extends Parent<T, F>{
	private H hoo;

	public H getHoo() {
		return hoo;
	}

	public void setHoo(H hoo) {
		this.hoo = hoo;
	}
	
	public static void main(String[] args) {
		Child<String, Boolean, Integer> c = new Child<String, Boolean, Integer>();
		Integer hoo = c.getHoo();
		String foo = c.getFoo();
		Boolean too = c.getToo();
	}
}
