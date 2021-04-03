package io.github.hooj0.annotation.base;

@SuppressWarnings("ALL")
public class SubDeprecatedAnnotation extends DeprecatedAnnotation {
	
	@Override
	public void doSomething() {
		System.out.println("abc");
	}
	
	/**
	 * 
	 * @author hoojo
	 * @createDate Oct 28, 2010 10:17:03 PM
	 * @param args
	 */
	public static void main(String[] args) {
		SubDeprecatedAnnotation sda = new SubDeprecatedAnnotation();
		sda.doSomething();
	}

}
