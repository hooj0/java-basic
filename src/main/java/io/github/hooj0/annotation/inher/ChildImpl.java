package io.github.hooj0.annotation.inher;

/*
 * 实现类不会继承接口的注解
 */
@SuppressWarnings("ALL")
public class ChildImpl implements ParentInterface {
	public void method() {
		System.out.println("this is ChildClass method");
	}
}
