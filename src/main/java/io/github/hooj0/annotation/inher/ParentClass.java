package io.github.hooj0.annotation.inher;

@SuppressWarnings("ALL")
@InheritedAnnotation
public class ParentClass {
	
	@InheritedAnnotation
	public void method() {
		System.out.println("this is method");
	}
}
