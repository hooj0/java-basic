package io.github.hooj0.annotation.inher;

/**
 * 父类
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 10:01:59
 */
@SuppressWarnings("ALL")
@InheritedAnnotation
public class ParentClass {
	
	@InheritedAnnotation
	public void method() {
		System.out.println("this is method");
	}
}
