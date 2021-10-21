package io.github.hooj0.annotation.other;

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
	public static void main(String[] args) {
		
	}
}
