package io.github.hooj0.annotation.inher;

/**
 * 方法和类上的注解都会被继承下来
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 10:00:56
 */
@SuppressWarnings("ALL")
public class ChildClass extends ParentClass {
	/*
	 * 重写将会覆盖掉父类方法的注解
	 */
	/*@Override
	public void method() {
		System.out.println("this is ChildClass method");
	}*/
}
