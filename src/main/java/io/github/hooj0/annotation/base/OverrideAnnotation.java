package io.github.hooj0.annotation.base;

/**
 * 覆盖注释
 *
 * @author hoojo
 * @version 1.0
 * @date Oct 28, 2010 10:04:33 PM
 */
@SuppressWarnings("ALL")
public class OverrideAnnotation {
	
	@Override
	public String toString() {
		return this.getClass().getName();
	}
	
	/*
	 * @Override如果当前方法使用Override注解的话，会提示父类并没有此方法可以覆盖
	 * 使用Override的最大用途是验证当前方法对父类的方法进行重写、覆盖，如果没有覆盖重写
	 * 成功将编译不通过
	 */
	public String tostring() {
		return this.getClass().getName();
	}
	
	public static void main(String[] args) {
		OverrideAnnotation oa = new OverrideAnnotation();
		System.out.println(oa.toString());
	}
}
