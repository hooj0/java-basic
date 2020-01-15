package io.github.hooj0.annotation.inher;

/**
 * 实现类不会继承接口的注解
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 10:01:14
 */
@SuppressWarnings("ALL")
public class ChildImpl implements ParentInterface {
	public void method() {
		System.out.println("this is ChildClass method");
	}
}
