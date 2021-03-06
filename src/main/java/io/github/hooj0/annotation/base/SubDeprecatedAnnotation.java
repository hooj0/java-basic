package io.github.hooj0.annotation.base;

/**
 * 子弃用注释
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 28, 2010 10:17:03 PM
 */
@SuppressWarnings("ALL")
public class SubDeprecatedAnnotation extends DeprecatedAnnotation {
	
	@Override
	public void doSomething() {
		System.out.println("abc");
	}
	
	public static void main(String[] args) {
		SubDeprecatedAnnotation sda = new SubDeprecatedAnnotation();
		sda.doSomething();
	}
}
