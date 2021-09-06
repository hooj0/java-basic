package io.github.hooj0.generic.generictype;

public class GenericType<T, F> {
	private T too;
	private F foo;
	
	public T getToo() {
		return too;
	}

	public void setToo(T too) {
		this.too = too;
	}

	public F getFoo() {
		return foo;
	}

	public void setFoo(F foo) {
		this.foo = foo;
	}

	/**
	 * <b>function:</b>
	 * @author hoojo
	 * @createDate Oct 6, 2010 9:30:02 PM
	 * @param args
	 */
	public static void main(String[] args) {
		GenericType<String, Integer> gt = new GenericType<String, Integer>();
		gt.setFoo(new Integer(22));
		gt.setToo(new String("tom"));
		String name = gt.getToo();
		Integer age = gt.getFoo();
		System.out.println(name + " : " + age);
	}
}
