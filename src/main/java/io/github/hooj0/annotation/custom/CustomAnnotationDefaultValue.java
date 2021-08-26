package io.github.hooj0.annotation.custom;

/**
 * <b>function:</b>为自定义annotation赋默认值
 * @author hoojo
 * @createDate Oct 30, 2010 2:52:03 PM
 * @file CustomAnnotationDefaultValue.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotationDefaultValue {
	String value() default "default value";
	int age() default 55;
	String name() default "zhangsan";
}
/*
 * 可以为属性赋默认值，这样在使用annotation的时候，就可以不为有默认属性的annotation赋值了
 */
