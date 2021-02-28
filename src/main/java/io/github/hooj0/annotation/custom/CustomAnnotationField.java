package io.github.hooj0.annotation.custom;

/**
 * 自定义annotation，且带自定义属性
 * @author hoojo
 * @createDate Oct 30, 2010 2:32:44 PM
 * @file CustomAnnotationField.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotationField {
	/*
	 * annotation的属性和方法有点像，需要带括号
	 * 可以理解成一个方法，当然这里贴切的说应该是属性
	 */
	String field();
}
