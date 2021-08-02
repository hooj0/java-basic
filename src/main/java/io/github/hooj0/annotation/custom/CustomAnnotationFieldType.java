package io.github.hooj0.annotation.custom;

/**
 * <b>function:</b>自定义Annotation，添加多个属性，且不同的类型
 * @author hoojo
 * @createDate Oct 30, 2010 3:17:30 PM
 * @file CustomAnnotationFieldType.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotationFieldType {
	String[] value();
	int[] ages();
	/*
	 * 数组类型也可以赋值一个
	 */
	String[] name() default "abc";
	/*
	 * 为数组类型赋默认值， 可以加public修饰；默认是public
	 */
	public String[] tel() default {"55667788", "8899554"};
	
	/*
	 * 也可以是枚举类型的
	 */
	CharCode code();
	
	/*
	 * 不能是自定义Java对象，Java类，封装类型、二维数组等
	 */
	//Student student();
	//Integer size();
	//Date date();
	//int[][] a();
}

@SuppressWarnings("ALL")
enum CharCode {
	A, B, C
}
/*
 * 自定义Annotation中可以出现原始类型、枚举类型、Class类类型及它们的一维数组类型
 */
