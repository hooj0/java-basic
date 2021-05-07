package io.github.hooj0.annotation.custom;

/**
 * <b>function:</b>为annotation添加自定义属性，可以是多个
 * @author hoojo
 * @createDate Oct 30, 2010 2:47:48 PM
 * @file CustomAnnotationCustomField.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotationCustomField {
	String customField();
	String name();
	int age();
}
/*
 * 自定义属性，可以多个，类型也可以不同
 */
