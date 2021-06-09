package io.github.hooj0.annotation.reflection;

/**
 * 目标对象，测试自定义Annotation
 * @author hoojo
 * @createDate Oct 30, 2010 4:17:43 PM
 * @file Target.java
 * @package com.hoo.annotation.reflection
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class Target {
	@TestAnnotation(name = "test", value = {"a", "b"})
	@SuppressWarnings("unchecked")
	@Deprecated
	public void method() {
		System.out.println("do something");
	}
}
