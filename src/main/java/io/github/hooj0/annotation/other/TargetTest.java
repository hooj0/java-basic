package io.github.hooj0.annotation.other;

/**
 * 目标测试
 *
 * @author hoojo
 * @version 1.0
 * @date 2022/02/08 10:03:16
 */
@SuppressWarnings("ALL")
@TargetAnnotation
public class TargetTest {
	/*
	 * 编译不通过，因为TargetAnnotation设置的是Type只能放在类和接口、枚举上面
	 * 并不能放在方法上面
	 * TargetAnnotation2只能放在局部变量上
	 */
	//@TargetAnnotation
	//@TargetAnnotation2
	public void method() {
		@TargetAnnotation2
		String name = "haha";
		System.out.println(name + "test doSomething");
	}
}
