package io.github.hooj0.annotation.custom;

/**
 * annotation的默认属性是value
 * @author hoojo
 * @createDate Oct 30, 2010 2:39:10 PM
 * @file CustomAnnotationDefault.java
 * @package com.hoo.annotation.custom
 * @project JavaAnnotation
 * @blog http://blog.csdn.net/IBM_hoojo
 * @email hoojo_@126.com
 * @version 1.0
 */
@SuppressWarnings("ALL")
public @interface CustomAnnotationDefault {
	String value();
}
/*
 * value是默认属性，在为默认属性赋值的时候可以省略属性名称
 */
